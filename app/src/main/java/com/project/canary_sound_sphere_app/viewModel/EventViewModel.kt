package com.project.canary_sound_sphere_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.project.canary_sound_sphere_app.model.EventItem
import com.project.canary_sound_sphere_app.repository.EventApiRepository
import com.project.canary_sound_sphere_app.state.EventState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ViewModel para manejar los datos y la lógica de la pantalla de eventos.
 * @param repo Repositorio para acceder a los datos de los eventos desde la API.
 */
@HiltViewModel
class EventViewModel @Inject constructor(private val repo: EventApiRepository): ViewModel() {

    // Flujo mutable para almacenar la lista de eventos
    private val _event= MutableStateFlow<List<EventItem>> (emptyList())

    // Flujo inmutable para exponer la lista de eventos al UI
    val events= _event.asStateFlow()

    // Estado actual de la pantalla
    var state by mutableStateOf(EventState())
        private set
    /**
     * Inicializa el ViewModel y obtiene la lista de eventos al inicializarlo.
     */
    init{
        fetchEvent()
    }
    /**
     * Función para obtener la lista de eventos desde el repositorio y actualizar el flujo de eventos.
     */
    private fun fetchEvent(){
        viewModelScope.launch {
            // Ejecutar en el hilo IO para realizar la solicitud a la API
            withContext(Dispatchers.IO){
                // Obtener la lista de eventos del repositorio
                val result=repo.getAllEvents()
                // Actualizar el flujo de eventos con los resultados obtenidos
                _event.value=result ?: emptyList()
            }
        }
    }
    /**
     * Función para obtener los detalles de un evento por su ID y actualizar el estado de la pantalla.
     * @param id ID del evento del cual se quieren obtener los detalles.
     */
    fun getEventById(id: String){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                // Obtener los detalles del evento del repositorio
                val result=repo.getEventDetails(id)
                // Actualizar el estado de la pantalla con los detalles del evento obtenido
                state=state.copy(
                    name = result?.name ?: "",
                    image = result?.image ?: "",
                    description = result?.description ?: "",
                    direction = result?.direction ?: "",
                    marker = result?.marker ?: "",
                    ticketStore = result?.ticketStore ?: "",
                    date = result?.date ?: "",
                    time = result?.time ?: "",
                    capacity = result?.capacity ?: 0
                )
            }
        }
    }
}