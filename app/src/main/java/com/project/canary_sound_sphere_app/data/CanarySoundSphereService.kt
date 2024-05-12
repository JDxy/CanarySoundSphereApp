package com.project.canary_sound_sphere_app.data

import com.project.canary_sound_sphere_app.di.ApiModule
import com.project.canary_sound_sphere_app.model.EventModel
import com.project.canary_sound_sphere_app.model.EventModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CanarySoundSphereService {
    // Instancia de Retrofit para realizar solicitudes a la API
    private val retrofit = ApiModule.providesRetrofit()

    // Método suspendido para obtener la lista de Eventos
    suspend fun getEvents(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            // Realiza la solicitud a la API para obtener la lista de Eventos
            val response = retrofit.create(CanarySoundSphereClient::class.java).getListEvents()
            // Devuelve la lista de Eventos si la respuesta no es nula, de lo contrario devuelve una lista vacía
            response.body()?.events ?: emptyList()
        }
    }

    // Método suspendido para obtener los detalles de un Evento específico por su ID
    suspend fun getDetailsEvent(id: String): EventModelDetails?{
        return withContext(Dispatchers.IO) {
            // Realiza la solicitud a la API para obtener los detalles de un Evento por su ID
            val response = retrofit.create(CanarySoundSphereClient::class.java).getDetailsEvent(id)
            // Devuelve los detalles del evento si la respuesta no es nula
            response.body()
        }
    }

}