package com.example.quoteappjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.quotesappjetpackcompose.DataManager
import com.example.quotesappjetpackcompose.model.Pages
import com.example.quotesappjetpackcompose.screens.LoadingScreen
import com.example.quotesappjetpackcompose.screens.QuoteAppInitialScreen
import com.example.quotesappjetpackcompose.screens.QuoteDetail
import com.example.quotesappjetpackcompose.screens.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            delay(3000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            if (DataManager.isDataLoaded.value) {
                if(DataManager.currentPage.value == Pages.LISTING)
                    QuoteAppInitialScreen { it, index ->
                        showToast(it.author)
                        DataManager.switchPages(it)
                        if(index == 2) {
                            showToast("position: ${it.quote}")
                        }
                        if(it.author.equals("Albert einstein", true)) {
                            showToast("You have selected ${it.author.lowercase().split(" ").joinToString { it.replaceFirstChar { it.uppercaseChar() }}}. I think u like him")
                        }
                    }
                else
                    DataManager.currentQuote?.let { QuoteDetail(it) }
            } else {
                LoadingScreen()
            }
        }
    }

}