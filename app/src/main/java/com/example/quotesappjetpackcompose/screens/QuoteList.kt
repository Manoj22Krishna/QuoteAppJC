package com.example.quotesappjetpackcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.quotesappjetpackcompose.model.Quote

@Composable
fun QuoteList(data: List<Quote>, onClick: (item: Quote, pos: Int) -> Unit) {
    LazyColumn ( content = {
        itemsIndexed(data) { index, it ->
            QuotesListItem(it) {
                onClick(it, index)
            }
        }
    })
}