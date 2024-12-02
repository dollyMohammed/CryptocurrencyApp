package com.example.cryptocurrencyapp.di

import androidx.compose.ui.unit.Constraints
import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.repostory.CoinRepositoryImpl
import com.example.cryptocurrencyapp.domain.repository.CoinRepestory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
    @Provides
    @Singleton
fun provideCoinRepostory(api:CoinPaprikaApi):CoinRepestory{
    return CoinRepositoryImpl(api)
}
}