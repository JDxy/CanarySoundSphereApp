package com.project.canary_sound_sphere_app.data

import com.project.canary_sound_sphere_app.model.AuthorModel
import com.project.canary_sound_sphere_app.model.EventModel
import com.project.canary_sound_sphere_app.model.AuthorModelDetails
import com.project.canary_sound_sphere_app.model.EventModelDetails
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT_EVENT_BY_ID
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT_GET_ALL_AUTHORS
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT_GET_ALL_EVENTS
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT_GET_AUTHOR_BY_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interfaz que define las funciones para realizar solicitudes a la API
 */
interface CanarySoundSphereClient {
    @GET(ENDPOINT_GET_ALL_EVENTS)
    suspend fun getListEvents(): Response<List<EventModel>>
    @GET(ENDPOINT_EVENT_BY_ID)
    suspend fun getDetailsEvent(@Path("id") id: String): Response<EventModelDetails>
    @GET(ENDPOINT_GET_ALL_AUTHORS)
    suspend fun getListAuthors(): Response<List<AuthorModel>>
    @GET(ENDPOINT_GET_AUTHOR_BY_ID)
    suspend fun getDetailsAuthor(@Path("id") id: String): Response<AuthorModelDetails>
}