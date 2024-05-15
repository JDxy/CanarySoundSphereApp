package com.project.canary_sound_sphere_app.repository

import com.project.canary_sound_sphere_app.data.CanarySoundSphereService
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.model.AuthorItemDetails
import com.project.canary_sound_sphere_app.model.toDomain
import javax.inject.Inject

/**
 * Repositorio para manejar las operaciones relacionadas con la API
 */
class AuthorApiRepository @Inject constructor(){

    // Instancia de CanarySoundSphereService para interactuar con la API
    private val api = CanarySoundSphereService()

    suspend fun getAllAuthors(): List<AuthorItem> {
        val response = api.getAuthors()
        return response.map { it.toDomain() }
    }

    suspend fun getAuthorDetails(id: String): AuthorItemDetails? {
        val response = api.getDetailsAuthor(id)
        return response?.toDomain()
    }
}