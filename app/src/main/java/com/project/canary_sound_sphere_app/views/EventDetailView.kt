package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.components.DetailTopBar
import com.project.canary_sound_sphere_app.state.EventState
import com.project.canary_sound_sphere_app.viewModel.EventViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventDetailView(viewModel: EventViewModel, navController: NavController, id: String) {
    LaunchedEffect(Unit){
       viewModel.getEventById(id)
    }
    Scaffold(
        topBar = {
            DetailTopBar(viewModel.state.name, navController, showBackButton = true)
        }
    ) {
        ContentEventsDetails(viewModel.state)
    }
}

@Composable
fun ContentEventsDetails(eventState: EventState) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 80.dp)
    ) {
        Text(text = "Name: ${eventState.name}")

        Text(text = "Description: ${eventState.description}")

        Text(text = "Direction: ${eventState.direction}")

        Text(text = "Marker: ${eventState.marker}")

        Text(text = "Ticket Store: ${eventState.ticketStore}")
    }
}
