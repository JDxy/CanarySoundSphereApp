package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Función componible para agregar espacio vertical
@Composable
fun SpacerV(size: Dp = 5.dp){
    Spacer(modifier = Modifier.height(size))
}

// Función componible para agregar espacio horizontal
@Composable
fun SpacerH(size: Dp = 5.dp){
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun titleText(text: String) {
    Text(
        text = text,
        color = Color.Magenta,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
    )
}
@Composable
fun detailsText(text: String){
    Text(
        text = text,
        color = Color.Black,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
    )
}