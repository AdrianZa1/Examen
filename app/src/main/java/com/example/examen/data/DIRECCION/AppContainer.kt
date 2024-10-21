package com.example.examen.data.DIRECCION

import DirecionRepository
import android.content.Context


/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val direcionRepository: DirecionRepository

}

/**
 * [AppContainer] implementation that provides instances of repositories for the application.
 */
class DefaultAppContainer(context: Context) : AppContainer {
    // Inicialización de la base de datos
    private val database = AppDatabase.getDatabase(context)

    // Implementación de direcionRepository
    override val direcionRepository: DirecionRepository by lazy {
        DirecionRepository(database)
    }

    // Implementación de estudiantesRepository

}
