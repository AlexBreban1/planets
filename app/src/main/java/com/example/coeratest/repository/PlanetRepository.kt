package com.example.coeratest.repository

import com.example.coeratest.data.Resource
import com.example.coeratest.model.PlanetItem

interface PlanetRepository {
    suspend fun getPlanets(): Resource<List<PlanetItem>>

    suspend fun insertOrUpdatePlanets(planets: List<PlanetItem>)
}