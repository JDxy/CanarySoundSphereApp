package com.project.canary_sound_sphere_app.model

data class EventItemDetails(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
    val direction: String,
    val marker: String,
    val ticketStore: String
)

/**
 * EventModelDetails
 * Retorna un nuevo objeto EventItemDetails con los datos formateados
 */
fun EventModelDetails.toDomain(): EventItemDetails {
    return EventItemDetails(id, name,  image, description, direction, marker, ticketStore)
}
