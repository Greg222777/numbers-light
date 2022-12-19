package com.nowik.numberslight.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NumberDetailsRoute(numberDetailsViewModel: NumberDetailsViewModel, numberId: String) {
    val uiState by numberDetailsViewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        numberDetailsViewModel.getNumberDetails(numberId)
    }
    NumberDetailsScreen(uiState)
}

@Composable
fun NumberDetailsScreen(uiState: NumberDetailsUiState) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        uiState.number.value?.let {
            AsyncImage(
                model = it.iconUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .size(60.dp)
            )
            Text(text = it.id, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }

    }

}