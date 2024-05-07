package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.project.canary_sound_sphere_app.R
import com.project.canary_sound_sphere_app.components.detailTopBar
import java.io.InputStream
import java.net.URL


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventDetailView(navController: NavController) {
    Scaffold(
        topBar = {
            detailTopBar("", navController, showBackButton = true)
        }
    ) {
        contentEventsDetails("https://github.com/JDxy/Canary-Sphere-Sound-App-Images/blob/main/15502681_1575153519168344_856285858_o-1-1287306393.jpg?raw=true",
            "https://github.com/JDxy/Canary-Sphere-Sound-App-Images/blob/main/15502681_1575153519168344_856285858_o-1-1287306393.jpg?raw=true",
            "Calle falsa",
            listOf("Día 1", "Día 2", "Día 3")
        )
    }
}

@Composable
fun contentEventsDetails(logoImageUrl: String, eventImageUrl: String, direction: String, days: List<String>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(top = 70.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.testimage),
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .width(400.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            Text(
                text = direction,
                fontSize = 18.sp,
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Aquí puedes agregar más imágenes si es necesario
            Image(
                painter = rememberAsyncImagePainter(logoImageUrl),
                contentDescription = "Imagen de logo",
                modifier = Modifier
                    .padding(start = 3.dp)
                    .border(1.dp, Color.Black)
                    .width(200.dp)

            )
            Image(
                painter = rememberAsyncImagePainter(eventImageUrl),
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .padding(start = 3.dp)
                    .border(1.dp, Color.Black)
                    .width(200.dp)
            )
        }
        Column(
            modifier = Modifier.padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            days.forEach { day ->
                Text(
                    text = day,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}
