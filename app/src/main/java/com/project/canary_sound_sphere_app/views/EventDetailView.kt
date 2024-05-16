package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.components.DetailTopBar
import com.project.canary_sound_sphere_app.components.DetailsText
import com.project.canary_sound_sphere_app.components.TitleText
import com.project.canary_sound_sphere_app.state.EventState
import com.project.canary_sound_sphere_app.ui.theme.whiteWithOpacity
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
        ContentEventDetails(viewModel.state, viewModel)
    }
}

@Composable
fun ContentEventDetails(eventState: EventState, viewModel: EventViewModel) {
    LazyColumn(modifier = Modifier
        .padding(10.dp,70.dp,10.dp,10.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            ImageEventDetailViews(viewModel.state)

            EventDetails(eventState)

            Text(text = "Direction: ${eventState.direction}")

            Text(text = "Marker: ${eventState.marker}")

            Text(text = "Ticket Store: ${eventState.ticketStore}")
        }
    }
}

@Composable
fun ImageEventDetailViews(eventState: EventState) {
    AsyncImage(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(20.dp)),
        model = eventState.image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
@Composable
fun EventDetails(eventState: EventState) {
    Box(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(whiteWithOpacity)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                TitleText("Fecha: ",false, modifier = Modifier, Color.Black)
                DetailsText(eventState.date)
            }

            Spacer(modifier = Modifier.padding(bottom = 10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                TitleText("Hora: ",false, modifier = Modifier, Color.Black)
                DetailsText(eventState.time)
            }

            Spacer(modifier = Modifier.padding(bottom = 10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TitleText("Aforo: ", false, modifier = Modifier, Color.Black)
                DetailsText(eventState.capacity.toString())
            }
        }
    }

    Box(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(whiteWithOpacity)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            TitleText("Descripción:",false, modifier = Modifier, Color.Black)
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            DetailsText(eventState.description)
        }
    }
}
