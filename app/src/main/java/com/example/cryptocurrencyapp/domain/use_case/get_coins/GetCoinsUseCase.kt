package com.example.cryptocurrencyapp.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepestory
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetCoinsUseCase @Inject constructor(private val repostory:CoinRepestory) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins= repostory.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected Error occured"))

        }catch (e:IOException){
            emit(Resource.Error("Could not reach server, check your internet connection"))

        }

    }
}