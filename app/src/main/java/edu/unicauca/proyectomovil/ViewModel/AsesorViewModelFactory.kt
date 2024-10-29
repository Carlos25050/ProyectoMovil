package edu.unicauca.proyectomovil.ViewModel

import AsesorViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.unicauca.proyectomovil.data.HorariosDisponiblesDao
import edu.unicauca.proyectomovil.data.PersonaDao

class AsesorViewModelFactory(private val personaDao: PersonaDao,  private val horariosDisponoblesDao: HorariosDisponiblesDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AsesorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AsesorViewModel(personaDao,horariosDisponoblesDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}