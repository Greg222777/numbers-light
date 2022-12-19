package com.nowik.numberslight.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp

@Composable
fun ListWithDetails(
    numbersViewModel: NumbersViewModel,
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
            NumbersListRoute(viewModel = numbersViewModel) {
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