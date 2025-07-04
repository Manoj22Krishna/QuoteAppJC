package com.example.quotesappjetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quoteappjc.R
import com.example.quotesappjetpackcompose.model.Quote

@Composable
fun QuoteDetail(quote: Quote) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.sweepGradient(
                    listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3),
                        Color(0xFF1E1E1E)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.padding(30.dp)
        ) {
            Column(
                Modifier.padding(16.dp, 24.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_quote),
                    contentDescription = "quote icon",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = quote.quote,
                    Modifier.padding(top = 19.dp),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = quote.author,
                    Modifier.padding(top = 19.dp),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
