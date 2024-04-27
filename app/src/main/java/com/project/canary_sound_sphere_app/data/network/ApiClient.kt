package com.project.canary_sound_sphere_app.data.network

import com.project.canary_sound_sphere_app.data.model.EventModelDetails
import com.project.canary_sound_sphere_app.data.model.ResultApi
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT
import com.project.canary_sound_sphere_app.util.Constants.Companion.ENDPOINT2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET(ENDPOINT)
    suspend fun getListEvents(): Response<ResultApi>

    @GET(ENDPOINT2)
    suspend fun getDetailsEvent(@Path("id") id: Int): Response<EventModelDetails>
}