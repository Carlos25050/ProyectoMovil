package edu.unicauca.proyectomovil.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource // Import para usar painterResource
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import edu.unicauca.proyectomovil.R
import androidx.compose.foundation.Image


@Composable
fun SeptimaPantalla(navController: NavController){
    PantallaSolicitudes()
}


@Composable
fun SolicitudCard(nombre: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        //elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del usuario utilizando Image en lugar de Icon
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .padding(4.dp)
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Nombre del usuario
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Botones de acción con Image en lugar de Icon
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = { /* Acción para aceptar */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.aceptar), // Icono de aceptar
                        contentDescription = "Aceptar",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { /* Acción para rechazar */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.rechazar), // Icono de rechazar
                        contentDescription = "Rechazar",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { /* Acción para ver más información */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.texto), // Icono de información
                        contentDescription = "Ver información",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun SolicitudesList() {
    val solicitudes = listOf(
        "Felipe Gomez",
        "Maria Torres",
        "Luis Hernandez"
    )

    LazyColumn {
        items(solicitudes) { nombre ->
            SolicitudCard(nombre = nombre)
        }
    }
}

@Composable
fun PantallaSolicitudes() {
    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
        Text(
            text = "Solicitudes de Clase",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        SolicitudesList()
    }
}