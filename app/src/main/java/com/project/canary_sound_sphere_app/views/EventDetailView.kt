package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.project.canary_sound_sphere_app.R
import com.project.canary_sound_sphere_app.components.detailTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventDetailView(navController: NavController) {
    Scaffold(
        topBar = {
            detailTopBar("", navController, showBackButton = true)
        }
    ) {
        contentEventsDetails()
    }
}

@Composable
fun contentEventsDetails() {
    val days = listOf("Día 1", "Día 2", "Día 3")

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
                text = "Calle falsa",
                fontSize = 18.sp,
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.testimage),
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .padding(start = 3.dp)
                    .border(1.dp, Color.Black)
                    .width(200.dp)

            )
            Image(
                painter = rememberAsyncImagePainter(R.drawable.testimage),
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