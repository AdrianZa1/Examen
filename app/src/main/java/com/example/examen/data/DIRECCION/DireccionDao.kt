package com.example.examen.data.DIRECCION

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DireccionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDireccion(direccion: Direcion)

    @Query("SELECT * FROM direccion")
    fun getAllDirecion(): Flow<List<Direcion>>

    @Query("SELECT * FROM direccion WHERE id = :id")
    suspend fun getDireccionById(id: Int): Direcion?

    @Query("DELETE FROM direccion WHERE id = :id")
    suspend fun deleteDireccionById(id: Int)
}
