package com.project.canary_sound_sphere_app.model

import com.google.gson.annotations.SerializedName

/**
 * EventModel
 * Mapea los datos de la respuesta de la API a objetos Kotlin para facilitar su manipulación y uso en la aplicación.
 */
data class EventModel(
    @SerializedName("_id") val id: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("name") val name: String
)



