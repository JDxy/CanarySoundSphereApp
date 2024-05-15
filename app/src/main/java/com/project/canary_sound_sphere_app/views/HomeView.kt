package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.components.AuthorList
import com.project.canary_sound_sphere_app.components.CustomTextButton
import com.project.canary_sound_sphere_app.components.EventList
import com.project.canary_sound_sphere_app.ui.theme.backgroundColor
import com.project.canary_sound_sphere_app.ui.theme.menuColor
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(eventViewModel: EventViewModel, authorViewModel: AuthorViewModel, navController: NavController) {

    val events by eventViewModel.events.collectAsState()
    val authors by authorViewModel.authors.collectAsState()
    var isEventsSelected by remember { mutableStateOf(true) }
    var isAuthorsSelected by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MainTopBar(
                title = "Canary Sound Sphere",
                isEventsSelected = isEventsSelected,
                isAuthorsSelected = isAuthorsSelected,
                onEventsClicked = {
                    isEventsSelected = true
                    isAuthorsSelected = false
                },
                onAuthorsClicked = {
                    isEventsSelected = false
                    isAuthorsSelected = true
                }
            )
        },
        modifier = Modifier.background(backgroundColor)
    ) {
        Column {
            if (isEventsSelected) {
                EventList(navController, events) // Mostrar lista de eventos
            } else if (isAuthorsSelected) {
                AuthorList(navController, authors) // Mostrar lista de autores
            }
        }
    }
}

/**
 * Composable que representa la barra superior principal de la aplicación. *
 * @param title El título que se mostrará en la barra superior.
 * @param isEventsSelected
 * @param isAuthorsSelected
 * @param onEventsClicked
 * @param onAuthorsClicked
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    isEventsSelected: Boolean,
    isAuthorsSelected: Boolean,
    onEventsClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomTextButton(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "EVENTOS",
                    isSelected = isEventsSelected,
                    textColor = Color.White,
                    onClick = onEventsClicked
                )
                CustomTextButton(
                    modifier = Modifier.padding(end = 20.dp),
                    text = "AUTORES",
                    isSelected = isAuthorsSelected,
                    textColor = Color.White,
                    onClick = onAuthorsClicked
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = menuColor
        )
    )
}
