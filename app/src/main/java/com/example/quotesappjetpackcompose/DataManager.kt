package com.example.quotesappjetpackcompose

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.quotesappjetpackcompose.model.Pages
import com.example.quotesappjetpackcompose.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManager {

    var data = emptyList<Quote>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote : Quote? = null

    val isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        data = Gson().fromJson(json, object : TypeToken<List<Quote>>() {}.type)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }
        else
            currentPage.value = Pages.LISTING
    }

}