package com.project.canary_sound_sphere_app.data

import com.project.canary_sound_sphere_app.data.model.EventModelDetails
import com.project.canary_sound_sphere_app.data.network.ApiService
import com.project.canary_sound_sphere_app.domain.model.EventItem

class ApiRepository {
    private val api = ApiService()
/*
    suspend fun getAllEvents(): List<EventItem> {
    val response = api.getEvents()

        return response.map { it.toDomain() }


}

suspend fun getEventDetails(id: Int): EventModelDetails? {
    val response = api.getDetailsEvent(id)
    return response?.toDomain()
}

 */
}