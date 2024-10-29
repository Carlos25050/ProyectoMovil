package edu.unicauca.proyectomovil.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.proyectomovil.Navegation.AppNavigation
import edu.unicauca.proyectomovil.Navegation.AppScreen
import edu.unicauca.proyectomovil.R

@Composable
fun TercerPantalla(navController: NavController) {
    Asesoria(navController)
}

@Composable
fun Asesoria(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Primera fila
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.agenda),
                    contentDescription = "Icono Agenda",
                    modifier = Modifier.size(80.dp)
                )
                Button(onClick = { navController.navigate(route = AppScreen.Agenda.route) }) {
                    Text(text = "Agenda")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notificaciones),
                    contentDescription = "Icono Notificaciones",
                    modifier = Modifier.size(80.dp)
                )
                Button(onClick = { navController.navigate(route = AppScreen.Notificaciones.route)}) {
                    Text(text = "Notificaciones")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Segunda fila
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.estadisticas),
                    contentDescription = "Icono Estadísticas",
                    modifier = Modifier.size(80.dp)
                )
                Button(onClick = {navController.navigate(route = AppScreen.Estadisticas.route) }) {
                    Text(text = "Estadísticas")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.historial),
                    contentDescription = "Icono Historial",
                    modifier = Modifier.size(80.dp)
                )
                Button(onClick = {navController.navigate(route = AppScreen.Historial.route)}) {
                    Text(text = "Historial")
                }
            }
        }
    }
}
