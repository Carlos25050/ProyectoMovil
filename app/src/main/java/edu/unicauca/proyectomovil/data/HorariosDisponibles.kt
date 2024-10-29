package edu.unicauca.proyectomovil.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horarios")
data class HorariosDisponibles(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val dia: Int,
    val mes: Int,
    val año: Int
)