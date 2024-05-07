package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.project.canary_sound_sphere_app.R
import com.project.canary_sound_sphere_app.components.detailTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthorDetailView(navController: NavController) {
    Scaffold(
        topBar = {
            detailTopBar("", navController, showBackButton = true)
        }
    ) {
        contentAuthorDetails( "https://github.com/JDxy/Canary-Sphere-Sound-App-Images/blob/main/1200px-estopa_20080613_007-1108137301.jpg?raw=true",
            "Title",
            "Año fundacion: 1992",
            "Genero: Rumba",
            "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\""
        )
    }
}

@Composable
fun contentAuthorDetails(artistImageUrl: String, title: String, foundationYear: String, gender: String, bodyText: String) {
    val list = listOf(foundationYear, gender )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(top = 70.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(artistImageUrl),
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .width(400.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            list.forEach { day ->
                Text(
                    text = day,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
        Text(
            text = bodyText,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 280.dp, top = 10.dp)
        ) {

            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .aspectRatio(2f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "Listas de reproduccion")
            }
        }
    }
}

