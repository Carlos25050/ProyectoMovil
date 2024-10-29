package edu.unicauca.proyectomovil.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Reemplazar si ya existe una persona con el mismo ID
    suspend fun insertPersona(persona: Persona)

//    @Insert
//    suspend fun insertPersona(persona: Persona)

    @Query("SELECT * FROM personas LIMIT 1")
    fun getPersona(): Flow<Persona>

    @Query("SELECT * FROM personas")
    fun getAllPersonas(): Flow<List<Persona>>

    @Query("DELETE FROM personas")
    suspend fun deleteAllPersonas()
}