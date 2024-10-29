package edu.unicauca.proyectomovil.Navegation

sealed class AppScreen (val route: String){
    //object TercerPantalla: AppScreen("Tercer_Pantalla")
    object FirstPantalla: AppScreen(route = "First_Pantalla")
    object SecondPantalla: AppScreen("Second_Pantalla")
    object TercerPantalla: AppScreen("Tercer_Pantalla")
    object Agenda: AppScreen("Agenda_Pantalla")
    object Estadisticas: AppScreen("Estadisticas_Pantalla")
    object Historial: AppScreen("Historial_Pantalla")
    object Notificaciones: AppScreen("Notificaciones_Pantalla")
}
