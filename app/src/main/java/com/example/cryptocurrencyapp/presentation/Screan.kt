package com.example.cryptocurrencyapp.presentation

sealed class Screan(val route:String){
    object CoinListScrean:Screan("coin_list_screan")
    object  CoinDetailScrean:Screan("coin_detail_screan")
}
