package edu.unicauca.proyectomovil.Navegation

import AsesorViewModel
import CuartaPantalla
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.unicauca.proyectomovil.Screens.SecondPantalla
import FirstPantalla
import edu.unicauca.proyectomovil.Screens.QuintaPantalla
import edu.unicauca.proyectomovil.Screens.SeptimaPantalla
import edu.unicauca.proyectomovil.Screens.SextaPantalla
import edu.unicauca.proyectomovil.Screens.TercerPantalla


@Composable
fun AppNavigation(asesorViewModel: AsesorViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FirstPantalla.route){
        composable(route = AppScreen.FirstPantalla.route){
            FirstPantalla(navController)
        }
        composable(route = AppScreen.SecondPantalla.route){
            SecondPantalla(navController,asesorViewModel)
        }
        composable(route = AppScreen.TercerPantalla.route){
            TercerPantalla(navController)
        }
        composable(route = AppScreen.Agenda.route){
            QuintaPantalla(navController, asesorViewModel)
        }
        composable(route = AppScreen.Estadisticas.route){
            CuartaPantalla(navController)
        }
        composable(route = AppScreen.Historial.route){
            SextaPantalla(navController, asesorViewModel)
        }
        composable(route = AppScreen.Notificaciones.route){
            SeptimaPantalla(navController)
        }
    }
}