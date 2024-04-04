package com.example.coeratest.di

import android.app.Application
import androidx.room.Room
import com.example.coeratest.dao.PlanetsDao
import com.example.coeratest.data.TestDatabase
import org.koin.dsl.module

fun provideDataBase(application: Application): TestDatabase =
    Room.databaseBuilder(
        application,
        TestDatabase::class.java,
        "test_coera"
    ).fallbackToDestructiveMigration().build()

fun provideDao(testDatabase: TestDatabase): PlanetsDao = testDatabase.planetsDao()


val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideDao(get()) }
}