package com.example.examen.ui.Direcion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.DIRECCION.Direcion
import DirecionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DireccionDetailViewModel(
    private val direcionRepository: DirecionRepository
) : ViewModel() {

    private val _direccion = MutableStateFlow<Direcion?>(null)
    val direccion: StateFlow<Direcion?> = _direccion

    fun loadDireccion(id: Int) {
        viewModelScope.launch {
            _direccion.value = direcionRepository.getDireccionById(id)
        }
    }

    fun deleteDireccion(id: Int) {
        viewModelScope.launch {
            direcionRepository.deleteDireccionById(id)
        }
    }
}
