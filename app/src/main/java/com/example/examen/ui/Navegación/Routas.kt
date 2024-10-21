package com.example.examen.ui.Navegación

import com.example.examen.ui.Direcion.DireccionListScreen
import com.example.examen.ui.Direcion.DireccionDetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Direcciones // Inicia en la pantalla de Direcciones
    ) {
        composable(Routes.Direcciones) {
            DireccionListScreen(onDireccionClick = { direccionId ->
                navController.navigate("direccion/$direccionId") // Navegar a los detalles de la dirección
            })
        }
        composable(Routes.DireccionDetail) { backStackEntry ->
            val direccionId = backStackEntry.arguments?.getString("direccionId")?.toInt() ?: 0
            DireccionDetailScreen(
                direccionId = direccionId,
                onDeleteSuccess = {
                    navController.popBackStack() // Regresar a la lista al eliminar
                }
            )
        }
    }
}
