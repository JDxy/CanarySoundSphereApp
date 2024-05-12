package com.project.canary_sound_sphere_app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.ui.theme.menuColor

@Composable
fun titleText(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
}
@Composable
fun detailsText(text: String){
    Text(
        text = text,
        color = Color.White,
        fontSize = 14.8.sp,
        fontWeight = FontWeight.Normal,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun detailTopBar(
    title: String,
    navController: NavController,
    showBackButton: Boolean = false

) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = menuColor
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