package com.project.canary_sound_sphere_app.model

import com.google.gson.annotations.SerializedName

/**
 * EventModelDetails
 * Mapea los datos de la respuesta de la API a objetos Kotlin para facilitar su manipulación y uso en la aplicación.
 */
data class EventModelDetails(
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("direction") val direction: String,
    @SerializedName("marker") val marker: String,
    @SerializedName("ticket_store") val ticketStore: String,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String,
    @SerializedName("capacity") val capacity: Int
)
