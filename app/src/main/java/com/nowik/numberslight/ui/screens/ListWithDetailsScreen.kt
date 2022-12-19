package com.nowik.numberslight.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nowik.numberslight.ui.screens.DynamicNumberDetailsRoute
import com.nowik.numberslight.ui.screens.NumbersListRoute
import com.nowik.numberslight.ui.viewmodels.NetworkStateViewModel
import com.nowik.numberslight.ui.viewmodels.NumberDetailsViewModel
import com.nowik.numberslight.ui.viewmodels.NumbersViewModel

@Composable
fun ListWithDetails(
    numbersViewModel: NumbersViewModel,
    connectivityViewModel : NetworkStateViewModel,
    numberDetailsViewModel: NumberDetailsViewModel
) {
    var selectedId by remember {
        mutableStateOf<String?>(null)
    }

    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(8.dp)
        ) {
            NumbersListRoute(viewModel = numbersViewModel, connectivityViewModel) {
                selectedId = it.id
            }
        }

        Divider(
            Modifier
                .width(1.dp)
                .fillMaxHeight()
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(8.dp)
        ) {
            selectedId?.let {
                DynamicNumberDetailsRoute(numberDetailsViewModel, it)
            }

        }
    }
}