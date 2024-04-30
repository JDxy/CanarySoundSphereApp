package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.util.Constants
import com.project.canary_sound_sphere_app.viewModel.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(viewModel: ViewModel, navController: NavController) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MainTopBar(title = "Canary Sound Sphere", isMenuExpanded = isMenuExpanded) {
                isMenuExpanded = !isMenuExpanded
            }
        },
        content = {
            // Contenido principal de tu pantalla
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, isMenuExpanded: Boolean, onMenuClicked: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(Constants.CUSTOM_BLACK)
        ),
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        navigationIcon = {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /* handle logout */ }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
    )

    if (isMenuExpanded) {
        DropdownMenu(
            expanded = isMenuExpanded,
            onDismissRequest = { /* handle menu dismiss */ },

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                // Opciones del menú
                OptionItem(text = "Opción 1")
                OptionItem(text = "Opción 2")
                OptionItem(text = "Opción 3")
            }
        }

    }
}

@Composable
fun OptionItem(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp) // Espaciado entre elementos
    )
}