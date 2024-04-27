package com.project.canary_sound_sphere_app.domain.model


import java.util.*
data class PokeItemDetails(
    val id: String,
    val name: String,
    val img: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense:Int,
    val speed: Int,
    val types: List<String>,
    val weight: Double,
    val height: Double
)
