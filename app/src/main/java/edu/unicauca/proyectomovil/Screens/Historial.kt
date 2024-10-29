package edu.unicauca.proyectomovil.Screens

import AsesorViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SextaPantalla(navController: NavController, asesorViewModel: AsesorViewModel){
    AgendaScreen(asesorViewModel)
}