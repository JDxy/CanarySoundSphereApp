package com.project.canary_sound_sphere_app.model

import com.google.gson.annotations.SerializedName

/**
 * AuthorModel
 * Mapea los datos de la respuesta de la API a objetos Kotlin para facilitar su manipulación y uso en la aplicación.
 */
data class AuthorModel(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
)