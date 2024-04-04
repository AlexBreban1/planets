package com.example.coeratest.model

import com.google.gson.annotations.SerializedName

data class Planets(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")
    val planetItems: List<PlanetItem>
)