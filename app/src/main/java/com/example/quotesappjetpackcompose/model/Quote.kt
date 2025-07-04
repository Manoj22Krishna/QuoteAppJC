package com.example.quotesappjetpackcompose.model

data class Quote(
    val author: String = "",
    val quote: String = ""
)

enum class Pages {
    LISTING,
    DETAIL
}