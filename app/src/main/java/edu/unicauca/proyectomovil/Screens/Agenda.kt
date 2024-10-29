package edu.unicauca.proyectomovil.Screens
import AsesorViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import edu.unicauca.proyectomovil.data.HorariosDisponibles
import java.util.Calendar
import androidx.compose.foundation.lazy.items

@Composable
fun QuintaPantalla(navController: NavController, asesorViewModel: AsesorViewModel){
    AgendaScreen(asesorViewModel)
}

@Composable
fun AgendaScreen(asesorViewModel: AsesorViewModel) {
    val context = LocalContext.current
    val selectedDays = remember { mutableStateListOf<String>() }  // Lista de fechas seleccionadas en formato String
    val horariosParaGuardar = remember { mutableStateListOf<HorariosDisponibles>() }  // Lista temporal para guardar en la BD
    var selectedHours by remember { mutableStateOf(mutableMapOf<String, String>()) }  // Mapa de horas para cada fecha

    // Observamos la lista de horarios guardados en la base de datos
    val horariosList by asesorViewModel.horariosList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Configura tu Agenda", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para seleccionar la fecha disponible
        Button(
            onClick = {
                mostrarDatePickerDialog(context) { year, month, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${month + 1}/$year"

                    // Agregar la fecha seleccionada a las listas temporales sin guardarla en la base de datos
                    selectedDays.add(selectedDate)
                    horariosParaGuardar.add(
                        HorariosDisponibles(
                            id = 0,
                            dia = dayOfMonth,
                            mes = month + 1,
                            año = year
                        )
                    )
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Seleccionar Fecha Disponible")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Fechas disponibles:")

        // Mostrar las fechas seleccionadas y las fechas guardadas
        LazyColumn {
            // Mostrar las fechas que se seleccionaron pero no se han guardado
            items(selectedDays.size) { index ->
                val date = selectedDays[index]

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = date, fontSize = 18.sp)

                    // Botón para eliminar la fecha de la lista temporal
                    Button(
                        onClick = {
                            selectedDays.removeAt(index)
                            horariosParaGuardar.removeAt(index)
                            selectedHours.remove(date)
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(text = "Eliminar")
                    }
                }

                Text(text = "Horas disponibles para $date:")
                BasicTextField(
                    value = selectedHours.getOrDefault(date, ""),
                    onValueChange = { selectedHours[date] = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            // Mostrar las fechas que ya están guardadas en la base de datos
            items(horariosList) { horario ->
                val date = "${horario.dia}/${horario.mes}/${horario.año}"

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = date, fontSize = 18.sp)

                    // Botón para eliminar el horario específico de la base de datos
                    Button(
                        onClick = {
                            asesorViewModel.deleteHorarioById(horario.id) // Llama al método para borrar el horario por ID
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(text = "Eliminar")
                    }
                }

                Text(text = "Horas disponibles para $date:")
                BasicTextField(
                    value = selectedHours.getOrDefault(date, ""),
                    onValueChange = { selectedHours[date] = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar las fechas seleccionadas en la base de datos
        Button(
            onClick = {
                horariosParaGuardar.forEach { horario ->
                    asesorViewModel.insertHorario(horario)
                }
                selectedDays.clear()           // Limpiar la lista temporal después de guardar
                horariosParaGuardar.clear()     // Limpiar la lista temporal de horarios para guardar
                selectedHours.clear()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Guardar Agenda")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para eliminar todos los horarios de la base de datos
        Button(
            onClick = {
                asesorViewModel.deleteAllHorarios()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Eliminar Todos")
        }
    }
}



// Función para mostrar el DatePickerDialog
fun mostrarDatePickerDialog(context: Context, onDateSelected: (Int, Int, Int) -> Unit) {
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            onDateSelected(year, month, dayOfMonth)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    datePickerDialog.show()
}