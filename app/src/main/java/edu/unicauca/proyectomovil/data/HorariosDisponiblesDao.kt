package edu.unicauca.proyectomovil.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HorariosDisponiblesDao {
    @Insert
    suspend fun insert(horario: HorariosDisponibles)

    @Query("SELECT * FROM horarios")
    suspend fun getAllHorarios(): List<HorariosDisponibles>

    // Método para eliminar todos los registros
    @Query("DELETE FROM horarios")
    suspend fun deleteAllHorarios()

    // Método para eliminar un horario específico por su ID
    @Query("DELETE FROM horarios WHERE id = :horarioId")
    suspend fun deleteHorarioById(horarioId: Int)
}