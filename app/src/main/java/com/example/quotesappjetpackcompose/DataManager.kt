package com.example.quotesappjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesappjetpackcompose.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManager {

    var data = emptyList<Quote>()
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

}