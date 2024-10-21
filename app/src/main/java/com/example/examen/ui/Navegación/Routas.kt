package com.example.examen.ui.Navegacion


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.examen.ui.Direcion.DireccionDetailScreen
import com.example.examen.ui.Direcion.DireccionListScreen

import com.example.examen.ui.Navegación.Routes

import com.example.examen.ui.iniciarsecion.LoginScreen
import com.example.examen.ui.iniciarsecion.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login // Inicia en la pantalla de login
    ) {
        composable(Routes.Login) {
            LoginScreen(
                onLoginClick = { email, password ->
                    navController.navigate("${Routes.Direcciones}")
                },
                onNavigateToRegister = {
                    navController.navigate(Routes.Register)
                },
                navController = navController
            )
        }

        // Pantalla de registro
        composable(Routes.Register) {
            RegisterScreen(
                onRegisterClick = { _, _ -> },
                onNavigateToLogin = {
                    navController.navigate(Routes.Login) // Regresar a la pantalla de login
                }
            )
        }

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
