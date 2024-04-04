package com.example.coeratest.ui.screens.planet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.coeratest.model.PlanetItem

@Composable
fun PlanetScreen(
    planetItem: PlanetItem
) {
    Column() {
        Text("Name: " + planetItem.name)
        Text("Population: " + planetItem.population)
    }
}