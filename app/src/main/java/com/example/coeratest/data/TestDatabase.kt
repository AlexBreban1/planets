package com.example.coeratest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coeratest.dao.PlanetEntity
import com.example.coeratest.dao.PlanetsDao

@Database(
    entities = [PlanetEntity::class],
    version = 1,
)
abstract class TestDatabase : RoomDatabase() {
    abstract fun planetsDao(): PlanetsDao

}