package com.example.coeratest.network

import com.example.coeratest.model.Planets
import retrofit2.http.GET

interface ExternalApi {
    @GET("planets")
    suspend fun getPlanets(): Planets
}