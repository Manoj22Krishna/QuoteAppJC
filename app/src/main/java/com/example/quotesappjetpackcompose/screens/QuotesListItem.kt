package com.example.quotesappjetpackcompose.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteappjc.R
import com.example.quotesappjetpackcompose.model.Quote

@Composable
fun QuotesListItem(quote: Quote, onClick : () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 19.dp),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                onClick()
//                showToast(context,"You clicked on the quote")
            }
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier.size(28.dp)
                )
                Image(
                    painter = painterResource(R.drawable.ic_quote),
                    colorFilter = ColorFilter.tint(Color.Cyan),
                    contentDescription = "quote image",
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = quote.quote,
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "",
                    Modifier
                        .background(Color(0XFFEEEEEE))
                        .height(2.dp)
                        .fillMaxWidth(0.4f)
                )
                Text(
                    text = quote.author,
                    modifier = Modifier.padding(top = 4.dp),
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraLight,
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                )
            }


        }
    }
}

fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}
