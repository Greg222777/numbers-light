package com.nowik.numberslight

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nowik.numberslight.ui.NumbersLightComposeApplication
import com.nowik.numberslight.ui.NumbersViewModel
import com.nowik.numberslight.ui.theme.NumbersLightTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("GREG", "oncreate")
        setContent {
            NumbersLightTheme {
              NumbersLightComposeApplication()
            }
        }
    }
}

@Composable
fun NumberItem() {

}

@Composable
fun Greeting(name: String) {
    val viewModel = koinViewModel<NumbersViewModel>()
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumbersLightTheme {
        Greeting("Android")
    }
}