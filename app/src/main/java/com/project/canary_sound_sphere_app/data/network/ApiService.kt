package com.project.canary_sound_sphere_app.data.network

import com.project.canary_sound_sphere_app.core.RetrofitHelper
import com.project.canary_sound_sphere_app.data.model.EventModel
import com.project.canary_sound_sphere_app.data.model.EventModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getEvents(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getListEvents()
            response.body()?.events ?: emptyList()
        }
    }
    suspend fun getDetailsEvent(id: Int): EventModelDetails?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDetailsEvent(id)
            response.body()
        }
    }
}