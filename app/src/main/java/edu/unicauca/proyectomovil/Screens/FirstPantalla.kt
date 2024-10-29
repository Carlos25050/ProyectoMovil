import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import edu.unicauca.proyectomovil.Navegation.AppScreen
import edu.unicauca.proyectomovil.R
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun FirstPantalla(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize() // La columna ocupa todo el tamaño de la pantalla
        .padding(16.dp) // Añade el padding
        .wrapContentSize(Alignment.Center)) // Centra el contenido de la columna
    {
        MyImage2()
        Text(
            text = "Bienvenido Esteban",
        )
        Button(onClick = { navController.navigate(route = AppScreen.SecondPantalla.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp)) {
            Text(text = "Perfil")
        }
        Button(onClick = { navController.navigate(route = AppScreen.TercerPantalla.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp)) {
            Text(text = "Asesorias")
        }
        Button(onClick = {  },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp)) {
            Text(text = "Configuraciones")
        }
    }
}

@Composable
fun MyImage2() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    // Configura el lanzador para abrir la galería
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? -> imageUri = uri }
    )

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable { launcher.launch("image/*") },
        contentAlignment = Alignment.Center
    ) {
        // Mostrar la imagen seleccionada o la imagen predeterminada
        if (imageUri != null) {
            Image(
                painter = rememberImagePainter(imageUri),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Foto de perfil predeterminada",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
        }
    }
}
