package com.project.canary_sound_sphere_app.repository

import com.project.canary_sound_sphere_app.data.CanarySoundSphereService
import com.project.canary_sound_sphere_app.model.EventItem
import com.project.canary_sound_sphere_app.model.EventItemDetails
import com.project.canary_sound_sphere_app.model.toDomain
import javax.inject.Inject

/**
 * Repositorio para manejar las operaciones relacionadas con la API
 */
class EventApiRepository @Inject constructor(){

    // Instancia de CanarySoundSphereService para interactuar con la API
    private val api = CanarySoundSphereService()

    suspend fun getAllEvents(): List<EventItem> {
        val response = api.getEvents()
        return response.map { it.toDomain() }
    }

    suspend fun getEventDetails(id: String): EventItemDetails? {
        val response = api.getDetailsEvent(id)
        return response?.toDomain()
    }
}