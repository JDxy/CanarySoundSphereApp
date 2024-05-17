package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
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
import com.project.canary_sound_sphere_app.ui.theme.blackWithOpacity
import com.project.canary_sound_sphere_app.ui.theme.selectiveYellow
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
        modifier = Modifier.background(Color.White),
        topBar = {
            MainTopBar(
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
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
                containerColor = blackWithOpacity
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
                    .fillMaxSize()
                    .background(blackWithOpacity),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextButton(
                    text = "EVENTOS",
                    isSelected = isEventsSelected,
                    textColor = if(isEventsSelected) selectiveYellow else
                        Color.White,
                    onClick = onEventsClicked
                )

                CustomTextButton(
                    text = "AUTORES",
                    isSelected = isAuthorsSelected,
                    textColor = if(isAuthorsSelected) selectiveYellow else
                        Color.White,
                    onClick = onAuthorsClicked
                )
            }
        }
    }
}
