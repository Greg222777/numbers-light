package com.nowik.numberslight.service

import com.nowik.numberslight.model.Number
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NumbersApi {
    @GET("json.php")
    suspend fun getAll(): Response<List<Number>>

    @GET("json.php")
    suspend fun get(@Query("name") numberId: String): Response<Number>
}