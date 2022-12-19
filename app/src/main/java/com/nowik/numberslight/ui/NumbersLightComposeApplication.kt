package com.nowik.numberslight.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nowik.numberslight.utils.WindowSize

@Composable
fun NumbersLightComposeApplication(windowClassSize: WindowSize) {
    val navController = rememberNavController()

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
        Surface {
            Box(modifier = Modifier.padding(innerPadding)) {
                NumbersLightNavHost(
                    navController = navController,
                    windowClassSize = windowClassSize
                )
            }
        }
    }
}