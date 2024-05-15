package com.project.canary_sound_sphere_app.model

import com.google.gson.annotations.SerializedName

/**
 * AuthorModelDetails
 * Mapea los datos de la respuesta de la API a objetos Kotlin para facilitar su manipulación y uso en la aplicación.
 */
data class AuthorModelDetails(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("foundation_year") val foundation_year: String,
    @SerializedName("music_type") val music_type: String,
    @SerializedName("description") val description: String,
    @SerializedName("music_list") val music_list: String
)
