package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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