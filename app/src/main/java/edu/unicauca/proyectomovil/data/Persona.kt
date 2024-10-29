package edu.unicauca.proyectomovil.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    val email: String,
    val specialization: String,
    val subjects: String,
    val levels: String,
    val rate: String
)