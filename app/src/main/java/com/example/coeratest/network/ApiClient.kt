package com.example.coeratest.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient(
) {
    private val BASE_URL = "https://swapi.dev/api/"
    private val retrofit: Retrofit
    val api: ExternalApi

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        api = retrofit.create(ExternalApi::class.java)
    }
}