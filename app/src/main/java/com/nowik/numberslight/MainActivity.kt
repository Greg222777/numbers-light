package com.nowik.numberslight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nowik.numberslight.ui.NumbersLightComposeApplication
import com.nowik.numberslight.ui.theme.NumbersLightTheme
import com.nowik.numberslight.utils.rememberWindowSizeClass


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumbersLightTheme {
              NumbersLightComposeApplication(rememberWindowSizeClass())
            }
        }
    }
}
