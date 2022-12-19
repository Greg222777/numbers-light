package com.nowik.numberslight.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun NumberItem(number: com.nowik.numberslight.model.Number, onclick: () -> Unit) {
    Column(Modifier.clickable { onclick() }) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            AsyncImage(
                model = number.iconUrl,
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
            Text(text = number.id)
        }
        Divider(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }

}

@Preview
@Composable
fun NumberItemPreview() {
    val number = com.nowik.numberslight.model.Number("999", "https://example.com/image.jpg")
    NumberItem(number = number){}
}