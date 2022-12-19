package com.nowik.numberslight.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.nowik.numberslight.model.Number
import com.nowik.numberslight.ui.NumberItem
import com.nowik.numberslight.ui.viewmodels.NetworkStateViewModel
import com.nowik.numberslight.ui.viewmodels.NumbersUiState
import com.nowik.numberslight.ui.viewmodels.NumbersViewModel

@Composable
fun NumbersListRoute(
    viewModel: NumbersViewModel,
    connectivityViewModel: NetworkStateViewModel,
    onNumberClicked: (Number) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAll()
    }
    val hasNetwork by connectivityViewModel.connectivityState.collectAsState()

    NumbersListScreen(uiState, onNumberClicked, hasNetwork)
}

@Composable
fun NumbersListScreen(
    uiState: NumbersUiState,
    onNumberClicked: (Number) -> Unit,
    hasNetwork: Boolean
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // if (test) {
        //     Text(text = "No network...", modifier = Modifier.align(Alignment.Center))
        // } else {
        LazyColumn() {
            uiState.numbers.value.forEach { number ->
                item {
                    NumberItem(number = number) {
                        onNumberClicked(number)
                    }
                }
            }
        }
        // }
    }
}

