package com.example.examen.data.DIRECCION

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "direccion")
data class Direcion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val calle: String,
    val descripcion: String,
    val imagenUri: Int,
    val numeracion: Double
)

