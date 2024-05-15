package com.project.canary_sound_sphere_app.model

import java.util.Locale

data class AuthorItem(
    val id: String,
    val name: String,
    val image: String,
)

fun AuthorModel.toDomain(): AuthorItem {
    val name = replaceFirstChar(name)
    return AuthorItem(id, name, image)
}

private fun replaceFirstChar(t: String): String {
    return t.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}