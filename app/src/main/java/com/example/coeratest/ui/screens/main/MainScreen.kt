package com.example.coeratest.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coeratest.model.PlanetItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = koinViewModel(),
) {
    val planets = viewModel.list
    if (viewModel.isLoading) {
        Row(
            modifier = Modifier.padding(end = 2.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator()
            Text(text = "Loading...")
        }

    } else {
        MainContent(
            planets = planets,
            navController
        )
    }

}

@Composable
fun MainContent(
    planets: List<PlanetItem>,
    navController: NavController
) {
    LazyColumn(){
        items(planets){
            Text(it.name)
        }
    }
}