package com.example.coeratest.di

import com.example.coeratest.network.ApiClient
import com.example.coeratest.repository.PlanetRepository
import com.example.coeratest.repository.PlanetRepositoryImpl
import com.example.coeratest.ui.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::MainViewModel)

    singleOf(::ApiClient)
    factory { (get() as ApiClient).api }
    factoryOf(::PlanetRepositoryImpl) bind PlanetRepository::class

}