package com.nowik.numberslight.service

import com.nowik.numberslight.model.Number
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NumbersNetworkServiceImpl : NumbersService {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://dev.tapptic.com/test/") //TODO put in local properties (should not be versioned)
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
            kotlin.runCatching {
                emit(numbersService.getAll().body())
            }

        }
    }

    override fun get(numberId: String): Flow<Number?> {
        return flow {
            kotlin.runCatching {
                emit(numbersService.get(numberId).body())
            }

        }
    }

}
