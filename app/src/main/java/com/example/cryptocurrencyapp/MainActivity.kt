package com.example.cryptocurrencyapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapp.presentation.Screan
import com.example.cryptocurrencyapp.presentation.coin_detail.CoinDetailScrean
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListScrean
import com.example.cryptocurrencyapp.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = Screan.CoinListScrean.route){
                        composable(route=Screan.CoinListScrean.route){
                            CoinListScrean(navController)
                        }
                        composable(route = Screan.CoinDetailScrean.route + "/{coinId}") { backStackEntry ->
                            val coinId = backStackEntry.arguments?.getString("coinId")
                            if (coinId != null) {
                                CoinDetailScrean(navController,coinId)
                            }
                        }
                    }
                }
            }
        }
    }
}

