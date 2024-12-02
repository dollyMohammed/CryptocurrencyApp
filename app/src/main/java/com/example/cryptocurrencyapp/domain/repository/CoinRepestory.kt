package com.example.cryptocurrencyapp.domain.repository

import android.adservices.adid.AdId
import com.example.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepestory {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String):CoinDetailDto
}