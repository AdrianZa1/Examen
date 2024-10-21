package com.example.examen

import android.app.Application
import com.example.examen.data.DIRECCION.AppContainer
import com.example.examen.data.DIRECCION.DefaultAppContainer

class ExameApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        // Inicializar el contenedor
        container = DefaultAppContainer(this)
    }
}
