package com.example.examen.data.DIRECCION

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Direcion::class], version = 2) // Incrementa la versión
abstract class AppDatabase : RoomDatabase() {

    abstract fun direccionDao(): DireccionDao // Cambiar a direccionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Esto permite la migración destructiva
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
