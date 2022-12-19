package com.nowik.numberslight.ui

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.nowik.numberslight.model.Number

@Composable
fun NumbersListRoute(viewModel: NumbersViewModel, onNumberClicked : (Number) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getAll()
    }

    NumbersListScreen(uiState, onNumberClicked)
}

@Composable
fun NumbersListScreen(uiState: NumbersUiState, onNumberClicked: (Number) -> Unit) {
    Log.e("GREG", "NUMBER LIST SCREEN")
    LazyColumn() {
        uiState.numbers.value.forEach { number ->
            item {
                NumberItem(number = number){
                        onNumberClicked(number)
                }
            }
        }
    }
}

