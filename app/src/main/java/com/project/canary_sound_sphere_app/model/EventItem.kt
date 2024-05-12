package com.project.canary_sound_sphere_app.model

import java.util.Locale

data class EventItem(
    val id: String,
    val logo: String,
    val name: String,
    val date: String,
    val time: String,
    val capacity: Int
)

fun EventModel.toDomain(): EventItem {
    val name = replaceFirstChar(name)
    return EventItem(id, logo, name, date, time, capacity)
}

private fun replaceFirstChar(t: String): String {
    return t.replaceFirstChar {
        // cada nombre con Mayuscula
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}