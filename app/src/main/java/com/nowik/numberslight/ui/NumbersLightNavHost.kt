package com.nowik.numberslight.ui

import android.content.res.Configuration
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nowik.numberslight.ui.screens.NumberDetailsRoute
import com.nowik.numberslight.ui.screens.NumbersListRoute
import com.nowik.numberslight.ui.viewmodels.NetworkStateViewModel
import com.nowik.numberslight.ui.viewmodels.NumberDetailsViewModel
import com.nowik.numberslight.ui.viewmodels.NumbersViewModel
import com.nowik.numberslight.utils.WindowSize
import org.koin.androidx.compose.koinViewModel

@Composable
fun NumbersLightNavHost(navController: NavHostController, windowClassSize: WindowSize) {

    val viewModel = koinViewModel<NumbersViewModel>()
    val numberDetailsViewModel = koinViewModel<NumberDetailsViewModel>()
    val connectivityViewModel = koinViewModel<NetworkStateViewModel>()
    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_LANDSCAPE
        && (windowClassSize == WindowSize.Expanded || windowClassSize == WindowSize.Medium)
    ) {
        ListWithDetails(viewModel,connectivityViewModel,  numberDetailsViewModel)
    } else {
        NavHost(
            navController = navController,
            startDestination = "list",
        ) {

            composable("list") {
                NumbersListRoute(viewModel, connectivityViewModel) {
                    navController.navigate("details/${it.id}")
                }
            }

            composable("details/{numberId}") {
                it.arguments?.getString("numberId")?.let { numberId ->
                    NumberDetailsRoute(
                        numberDetailsViewModel = numberDetailsViewModel,
                        numberId = numberId
                    )
                }
            }
        }
    }
}