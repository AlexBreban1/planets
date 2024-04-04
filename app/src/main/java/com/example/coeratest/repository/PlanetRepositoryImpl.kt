package com.example.coeratest.repository

import com.example.coeratest.dao.PlanetsDao
import com.example.coeratest.data.Resource
import com.example.coeratest.model.PlanetItem
import com.example.coeratest.network.ExternalApi

class PlanetRepositoryImpl(
    private val api: ExternalApi,
    private val dao: PlanetsDao
) : PlanetRepository {

    override suspend fun getPlanets(): Resource<List<PlanetItem>> {
        return try {
            Resource.Loading(data = true)

            val itemList = api.getPlanets().planetItems


            if (itemList.isNotEmpty()) Resource.Loading(data = false)
            Resource.Success(data = itemList)

        } catch (exception: Exception) {
            Resource.Error(message = exception.message.toString())
        }
    }

    override suspend fun insertOrUpdatePlanets(planets: List<PlanetItem>) {
        val planetEntities = planets.map { it.toEntity() }
        dao.insertPlanets(planetEntities)
    }
}