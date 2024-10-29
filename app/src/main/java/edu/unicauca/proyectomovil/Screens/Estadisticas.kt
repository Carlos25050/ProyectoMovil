import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment  // Para centrar elementos en filas y columnas
import androidx.compose.foundation.background  // Para establecer el color de fondo de un elemento
import androidx.compose.material3.Divider  // Para agregar líneas divisoras entre elementos
import androidx.compose.foundation.layout.fillMaxWidth  // Para que un elemento ocupe todo el ancho de la pantalla


@Composable
fun CuartaPantalla(navController: NavController){
    Tabla()
}

data class Asesoria(
    val dia: String,
    val cantidad: String,
    val valor: String,
    val horas: String
)

@Composable
fun Tabla() {
    val asesorias = listOf(
        Asesoria("Lunes", "3", "$150", "6"),
        Asesoria("Martes", "2", "$120", "4"),
        Asesoria("Miércoles", "4", "$180", "8"),
        Asesoria("Jueves", "1", "$100", "2"),
        Asesoria("Viernes", "3", "$150", "6")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Cabecera de la tabla
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Día",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Cantidad",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Valor",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Horas",
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp)

        // Filas de la tabla con fondo alterno y separadores
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(items = asesorias) { asesoria ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (asesorias.indexOf(asesoria) % 2 == 0) Color.LightGray else Color.White)
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = asesoria.dia,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    )
                    Text(
                        text = asesoria.cantidad,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (asesoria.cantidad.toInt() > 3) Color.Green else Color.Red
                    )
                    Text(
                        text = asesoria.valor,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    )
                    Text(
                        text = asesoria.horas,
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    )
                }
                Divider(color = Color.Gray, thickness = 0.5.dp)
            }

            // Total de la semana
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color.Yellow),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total",
                        modifier = Modifier.weight(1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = asesorias.sumOf { it.cantidad.toInt() }.toString(),
                        modifier = Modifier.weight(1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "$${asesorias.sumOf { it.valor.drop(1).toInt() }}",
                        modifier = Modifier.weight(1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = asesorias.sumOf { it.horas.toInt() }.toString(),
                        modifier = Modifier.weight(1f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}