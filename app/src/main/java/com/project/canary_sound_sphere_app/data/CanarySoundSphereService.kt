package com.project.canary_sound_sphere_app.data

import com.project.canary_sound_sphere_app.di.ApiModule
import com.project.canary_sound_sphere_app.model.AuthorModel
import com.project.canary_sound_sphere_app.model.AuthorModelDetails
import com.project.canary_sound_sphere_app.model.EventModel
import com.project.canary_sound_sphere_app.model.EventModelDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CanarySoundSphereService {

    // Instancia de Retrofit para realizar solicitudes a la API
    private val retrofit = ApiModule.providesRetrofit()

    /**
     * Método getEvent
     * Devuelve la lista de Eventos si la respuesta no es nula, de lo contrario devuelve una lista vacía
     */
    suspend fun getEvents(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            // Realiza la solicitud a la API para obtener la lista de Eventos
            val response = retrofit.create(CanarySoundSphereClient::class.java).getListEvents()
            response.body() ?: emptyList()
        }
    }

    /**
     * Método getDetailEvent
     * Devuelve un Event concreto si lo encuentra
     */
    suspend fun getDetailsEvent(id: String): EventModelDetails?{
        return withContext(Dispatchers.IO) {
            // Realiza la solicitud a la API para obtener el evento en funcion de su id
            val response = retrofit.create(CanarySoundSphereClient::class.java).getDetailsEvent(id)
            response.body()
        }
    }

    /**
     * Método getAuthor se utiliza para obtener la lista de Authors
     */
    suspend fun getAuthors(): List<AuthorModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CanarySoundSphereClient::class.java).getListAuthors()
            response.body() ?: emptyList()
        }
    }

    /**
     * Método getDetailAuthor se utiliza para obtener un Author concreto
     */
    suspend fun getDetailsAuthor(id: String): AuthorModelDetails?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CanarySoundSphereClient::class.java).getDetailsAuthor(id)
            response.body()
        }
    }
}