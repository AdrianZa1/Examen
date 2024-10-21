package com.example.examen.ui.Direcion

import DirecionRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.DIRECCION.Direcion
import com.example.inventory.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DirecionViewModel(
    private val direcionRepository: DirecionRepository
) : ViewModel() {

    // Cambiar cursos a direcciones para reflejar el cambio
    val direcciones: StateFlow<List<Direcion>> = direcionRepository.getAllDirecciones()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    init {
        // Llamar a la función para insertar direcciones al inicializar el ViewModel
        viewModelScope.launch {
            insertInitialDirecciones()
        }
    }

    private suspend fun insertInitialDirecciones() {
        // Comprobar si ya hay direcciones antes de insertar
        if (direcciones.value.isEmpty()) {
            val initialDirecciones = listOf(
                Direcion(calle = "Avenida Siempre Viva", descripcion = "Calle famosa de Springfield", imagenUri = R.drawable.culinary, numeracion = 100.0),
                Direcion(calle = "Calle Falsa 123", descripcion = "Dirección inventada", imagenUri = R.drawable.design, numeracion = 80.0),
                Direcion(calle = "Boulevard de los Sueños Rotos", descripcion = "Calle emblemática", imagenUri = R.drawable.drawing, numeracion = 90.0),
                Direcion(calle = "Camino Real", descripcion = "Ruta histórica", imagenUri = R.drawable.ecology, numeracion = 85.0),
                Direcion(calle = "Plaza Mayor", descripcion = "Centro de la ciudad", imagenUri = R.drawable.engineering, numeracion = 95.0)
            )

            // Insertar las direcciones iniciales en la base de datos
            initialDirecciones.forEach { direccion ->
                direcionRepository.insertDireccion(direccion)
            }
        }
    }
}

