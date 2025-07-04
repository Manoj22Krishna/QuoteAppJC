package com.example.quoteappjc

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.quotesappjetpackcompose.DataManager
import com.example.quotesappjetpackcompose.screens.LoadingScreen
import com.example.quotesappjetpackcompose.screens.QuoteAppInitialScreen
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
                QuoteAppInitialScreen(this)
            } else {
                LoadingScreen()
            }
        }
    }

}