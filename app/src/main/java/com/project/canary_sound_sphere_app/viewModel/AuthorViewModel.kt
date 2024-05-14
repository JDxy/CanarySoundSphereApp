package com.project.canary_sound_sphere_app.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.repository.AuthorApiRepository
import com.project.canary_sound_sphere_app.state.AuthorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthorViewModel @Inject constructor(private val repo: AuthorApiRepository): ViewModel() {
    // Flujo mutable para almacenar la lista de autores
    private val _authors = MutableStateFlow<List<AuthorItem>>(emptyList())
    val authors = _authors.asStateFlow() // Flujo inmutable para exponer la lista de autores al UI

    // Estado actual de la pantalla
    var state by mutableStateOf(AuthorState())
        private set

    // Inicialización del ViewModel, se llama automáticamente al crear una instancia del ViewModel
    init {
        fetchAuthors() // Obtener la lista de autores al inicializar el ViewModel
    }

    // Función para obtener la lista de autores
    private fun fetchAuthors() {
        viewModelScope.launch {
            // Ejecutar en el hilo IO para realizar la solicitud a la API
            withContext(Dispatchers.IO) {
                // Obtener la lista de autores del repositorio
                val result = repo.getAllAuthors()
                // Actualizar el flujo de autores con los resultados obtenidos
                _authors.value = result ?: emptyList()
            }
        }
    }

    // Función para obtener los detalles de un autor por su ID
    fun getAuthorById(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                // Obtener los detalles del autor del repositorio
                val result = repo.getAuthorDetails(id)
                // Actualizar el estado de la pantalla con los detalles del autor obtenidos
                state = state.copy(
                    name = result?.name ?: "",
                    image = result?.image ?: "",
                    foundation_year = result?.foundation_year ?: "",
                    music_type = result?.music_type ?: "",
                    description = result?.description ?: "",
                    music_list = result?.music_list ?: ""
                )
            }
        }
    }
}
