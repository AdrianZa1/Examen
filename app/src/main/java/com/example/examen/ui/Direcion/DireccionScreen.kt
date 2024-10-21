package com.example.examen.ui.Direcion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.ui.AppViewModelProvider



@Composable
fun DireccionListScreen(
    onDireccionClick: (Int) -> Unit, // Callback para navegar a los detalles de la dirección
    viewModel: DirecionViewModel = viewModel(factory = AppViewModelProvider.Factory) // Obtención del ViewModel
) {
    val direcciones = viewModel.direcciones.collectAsState(initial = emptyList()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Direcciones",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de direcciones
        direcciones.forEach { direccion ->
            Text(
                text = direccion.calle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onDireccionClick(direccion.id) }, // Navegar al hacer clic
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

