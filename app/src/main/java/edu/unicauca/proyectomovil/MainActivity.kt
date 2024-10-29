package edu.unicauca.proyectomovil

import AsesorViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import edu.unicauca.proyectomovil.Navegation.AppNavigation
import edu.unicauca.proyectomovil.ViewModel.AsesorViewModelFactory
import edu.unicauca.proyectomovil.data.HorariosDisponiblesDatabase
import edu.unicauca.proyectomovil.data.PersonaDao
import edu.unicauca.proyectomovil.data.PersonaDatabase
import edu.unicauca.proyectomovil.ui.theme.ProyectoMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = PersonaDatabase.getDatabase(application)
        val personaDao = database.personaDao()

        val horariosDatabase = HorariosDisponiblesDatabase.getDatabase(application)
        val horariosDisponiblesDao = horariosDatabase.horariosDao()

//        val fotoPerfilDatabase = FotoPerfilDatabase.getDatabase(application)
//        val fotoPerfilDao = fotoPerfilDatabase.fotoPerfilDao()

        // Inicialización del ViewModel utilizando el Factory
        val asesorViewModel: AsesorViewModel by viewModels {
            AsesorViewModelFactory(personaDao, horariosDisponiblesDao)
        }


        enableEdgeToEdge()
        setContent {
            ProyectoMovilTheme() {
                //val esteban: PersonaDao
                AppNavigation(asesorViewModel = asesorViewModel)
            }

        }
    }
}


