package com.nowik.numberslight.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

@Composable
fun NumbersLightComposeApplication() {
    val navController = rememberNavController()

    Log.e("GREG", "APP SCAFFOLD")

    // A surface container using the 'background' color from the theme
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Numbers Light",
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = "Back"
                    )
                }
            }
        )
    }) { innerPadding ->
        Surface() {
            Box(modifier = Modifier.padding(innerPadding)) {
                NumbersLightNavHost(
                    navController = navController
                )
            }
        }
    }
}