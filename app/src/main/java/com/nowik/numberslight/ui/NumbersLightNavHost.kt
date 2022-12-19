package com.nowik.numberslight.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun NumbersLightNavHost(navController: NavHostController) {
    Log.e("GREG", "nav host")
    val viewModel = koinViewModel<NumbersViewModel>()
    val numberDetailsViewModel = koinViewModel<NumberDetailsViewModel>()
    NavHost(
        navController = navController,
        startDestination = "list",
    ) {

        composable("list") {
            NumbersListRoute(viewModel) {
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