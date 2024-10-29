package edu.unicauca.proyectomovil.Screens

import AsesorViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.proyectomovil.Navegation.AppScreen
import edu.unicauca.proyectomovil.R
import edu.unicauca.proyectomovil.data.Persona

@Composable
fun SecondPantalla(navController: NavController, asesorViewModel: AsesorViewModel){
    EditProfileScreen(navController, asesorViewModel)
}

@Composable
fun EditProfileScreen(navController: NavController, asesorViewModel: AsesorViewModel) {
    val lastSavedName by asesorViewModel.lastSavedName.collectAsState()
    val lastSavedEmail by asesorViewModel.lastSavedEmail.collectAsState()
    val lastSavedSpecialization by asesorViewModel.lastSavedSpecialization.collectAsState()
    val lastSavedSubjects by asesorViewModel.lastSavedSubjects.collectAsState()
    val lastSavedLevels by asesorViewModel.lastSavedLevels.collectAsState()
    val lastSavedRate by asesorViewModel.lastSavedRate.collectAsState()

    var name by remember { mutableStateOf(lastSavedName) }
    var email by remember { mutableStateOf(lastSavedEmail) }
    var specialization by remember { mutableStateOf(lastSavedSpecialization) }
    var subjects by remember { mutableStateOf(lastSavedSubjects) }
    var levels by remember { mutableStateOf(lastSavedLevels) }
    var rate by remember { mutableStateOf(lastSavedRate) }

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen de perfil con opción de cambiarla
                Image(
                    painter = painterResource(id = R.drawable.perfil), // Usa un recurso de imagen
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )

                Text("Cambiar Foto", color = Color.Blue)

                Spacer(modifier = Modifier.height(24.dp))

                // Campos de texto similares a los de la imagen
                BasicField("Nombre", name) { name = it }
                BasicField("Correo Electrónico", email, keyboardType = KeyboardType.Email) { email = it }
                BasicField("Especialización", specialization) { specialization = it }
                BasicField("Materias que enseña", subjects) { subjects = it }
                BasicField("Niveles de Estudio", levels) { levels = it }
                BasicField("Tarifa por hora ($)", rate, keyboardType = KeyboardType.Number) { rate = it }

                Spacer(modifier = Modifier.height(32.dp))

                // Botón similar al de la imagen}

                Row {
                    Button(
                        onClick = {
                            val newPersona = Persona(
                                id = 1,
                                name = name,
                                email = email,
                                specialization = specialization,
                                subjects = subjects,
                                levels = levels,
                                rate = rate
                            )
                            //asesorViewModel.addPersona(newPersona)
                            asesorViewModel.addOrUpdatePersona(newPersona)


                        }
                    ) {
                        Text("Guardar Cambios")
                    }

                    Button(
                        onClick = {
                            navController.navigate(route = AppScreen.FirstPantalla.route)
                        },
                        /*modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(vertical = 8.dp)*/
                    ) {
                        Text("Volver")
                    }

                }
                Button(onClick = {
                    asesorViewModel.deleteAllPersonas() // Llamar la función para eliminar
                }) {
                    Text("Eliminar Datos")
                }

            }
        }
    )
}

@Composable
fun BasicField(
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label)
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
