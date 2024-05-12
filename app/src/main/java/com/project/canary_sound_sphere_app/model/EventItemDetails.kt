package com.project.canary_sound_sphere_app.model

data class EventItemDetails(
    val id: String,
    val image: String,
    val description: String,
    val direction: String,
    val marker: String,
    val ticketStore: String
)

fun EventModelDetails.toDomain(): EventItemDetails {
    // Retorna un nuevo objeto EventItemDetails con los datos formateados
    return EventItemDetails(id, image, description, direction,marker, ticketStore)
}
