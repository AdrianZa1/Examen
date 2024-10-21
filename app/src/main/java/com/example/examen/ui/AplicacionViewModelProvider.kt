package com.example.inventory.ui




import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory



import com.example.examen.ExameApplication
import com.example.examen.ui.Direcion.DireccionDetailViewModel
import com.example.examen.ui.Direcion.DirecionViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val appContainer = inventoryApplication().container
            // Inicializa el ViewModel direcionViewModel con el direcionRepository
            DirecionViewModel(appContainer.direcionRepository)
        }
        initializer {
            val appContainer = inventoryApplication().container
            // Inicializa el ViewModel direcionViewModel con el direcionRepository
            DireccionDetailViewModel(appContainer.direcionRepository)
        }
    }
}


/**
 * Función de extensión para consultar el objeto [Application] y devolver una instancia de
 * [DiarioApplication].
 */
fun CreationExtras.inventoryApplication(): ExameApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ExameApplication)

