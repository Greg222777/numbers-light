package com.nowik.numberslight.service

import android.util.Log
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import com.nowik.numberslight.model.Number
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

class NumbersNetworkServiceImpl : NumbersService {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/test/")
        .client(createClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val numbersService = retrofit.create(NumbersApi::class.java)

    private fun createClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }

    override fun getAll(): Flow<List<Number>?> {
        return flow {
            emit(numbersService.getAll().body())
        }
    }

    override fun get(numberId: Int): Flow<Number?> {
        return flow {
            emit(numbersService.get(1).body())
        }
    }

}
