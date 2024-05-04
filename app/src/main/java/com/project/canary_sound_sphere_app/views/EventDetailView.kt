package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.project.canary_sound_sphere_app.R
import com.project.canary_sound_sphere_app.components.detailsText
import com.project.canary_sound_sphere_app.components.titleText
import com.project.canary_sound_sphere_app.util.Constants
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventDetailView(navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar("", navController, showBackButton = true)
        }
    ) {
        contentEventsDetails()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    navController: NavController,
    showBackButton: Boolean = false

    ) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(Constants.CUSTOM_BLACK)
        ),
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun contentEventsDetails() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Primera imagen y texto
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
            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp),
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
        Text(
            text = "Dias 31241234513431423432424324121",
            fontSize = 18.sp
        )
    }
}






