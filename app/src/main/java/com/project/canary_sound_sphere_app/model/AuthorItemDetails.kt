package com.project.canary_sound_sphere_app.model

data class AuthorItemDetails(
    val id: String,
    val name: String,
    val image: String,
    val foundation_year: String,
    val music_type: String,
    val description: String,
    val music_list: String
)

/**
 * AuthorModelDetails
 * Retorna un nuevo objeto AuthorItemDetails con los datos formateados
 */
fun AuthorModelDetails.toDomain(): AuthorItemDetails {
    return AuthorItemDetails(id, name,  image, foundation_year, music_type, description, music_list)
}
