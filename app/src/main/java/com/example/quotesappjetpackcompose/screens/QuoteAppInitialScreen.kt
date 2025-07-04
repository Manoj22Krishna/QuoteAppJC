package com.example.quotesappjetpackcompose.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesappjetpackcompose.DataManager

@Composable
fun QuoteAppInitialScreen(context: Context) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quotes App",
            Modifier.padding(19.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Cyan
        )
        QuoteList(data = DataManager.data) { it, index ->
            showToast(context, it.author)
            if(index == 2) {
                showToast(context, "position: ${it.quote}")
            }
            if(it.author.equals("Albert einstein", true)) {
                showToast(context,"You have selected ${it.author.lowercase().split(" ").joinToString { it.replaceFirstChar { it.uppercaseChar() }}}. I think u like him")
            }
        }
    }
}

@Composable
@Preview
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Loading....",
            color = Color.Blue,
            style = MaterialTheme.typography.titleSmall
        )
    }
}