package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.components.AuthorList
import com.project.canary_sound_sphere_app.components.CustomTextButton
import com.project.canary_sound_sphere_app.components.EventList
import com.project.canary_sound_sphere_app.ui.theme.menuColor
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    eventViewModel: EventViewModel,
    authorViewModel: AuthorViewModel,
    navController: NavController
) {
    val events by eventViewModel.events.collectAsState()
    val authors by authorViewModel.authors.collectAsState()
    var isEventsSelected by remember { mutableStateOf(true) }
    var isAuthorsSelected by remember { mutableStateOf(false) }
    var isMenuVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MainTopBar(
                title = "",
                isEventsSelected = isEventsSelected,
                isAuthorsSelected = isAuthorsSelected,
                isMenuVisible = isMenuVisible,
                onMenuClicked = { isMenuVisible = !isMenuVisible },
                onEventsClicked = {
                    isEventsSelected = true
                    isAuthorsSelected = false
                    isMenuVisible = false
                },
                onAuthorsClicked = {
                    isEventsSelected = false
                    isAuthorsSelected = true
                    isMenuVisible = false
                }
            )
        }
    ) {
        Column {
            if (isEventsSelected) {
                EventList(navController, events)
            } else if (isAuthorsSelected) {
                AuthorList(navController, authors)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainTopBar(
    title: String,
    isEventsSelected: Boolean,
    isAuthorsSelected: Boolean,
    isMenuVisible: Boolean,
    onMenuClicked: () -> Unit,
    onEventsClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
) {
    Column {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = onMenuClicked, modifier = Modifier.padding(start = 8.dp)) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = menuColor
            )
        )
        Divider(color = Color.Gray, thickness = 1.dp)
        AnimatedVisibility(
            visible = isMenuVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(menuColor),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextButton(
                    text = "Eventos",
                    isSelected = isEventsSelected,
                    textColor = Color.White,
                    onClick = onEventsClicked
                )
                Spacer(modifier = Modifier.width(16.dp))
                CustomTextButton(
                    text = "Autores",
                    isSelected = isAuthorsSelected,
                    textColor = Color.White,
                    onClick = onAuthorsClicked
                )
            }
        }
    }
}
