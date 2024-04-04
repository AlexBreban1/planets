package com.example.coeratest.ui.screens.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coeratest.data.Resource
import com.example.coeratest.model.PlanetItem
import com.example.coeratest.repository.PlanetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private var repository: PlanetRepository) : ViewModel() {


    var list: List<PlanetItem> by mutableStateOf(listOf())
    var isLoading: Boolean by mutableStateOf(true)
    val sortedPlanets: List<PlanetItem> by mutableStateOf(listOf())

    //
    init {
        getPlanets()
    }


    private fun getPlanets() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                when (val response = repository.getPlanets()) {
                    is Resource.Success -> {
                        list = response.data!!
                        if (list.isNotEmpty()) isLoading = false
                        repository.insertOrUpdatePlanets(list)

                        val sortedPlanets = list.sortedBy { it.films.size }
                        list = sortedPlanets
                    }

                    is Resource.Error -> {
                        isLoading = false
                        Log.e("Network", "get planets: Failed getting planets")
                    }

                    else -> {
                        isLoading = false
                    }
                }

            } catch (exception: Exception) {
                isLoading = false
                Log.d("Network", "get planets error: ${exception.message.toString()}")
            }

        }


    }


}