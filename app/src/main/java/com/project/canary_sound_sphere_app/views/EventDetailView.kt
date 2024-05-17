package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
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
import com.project.canary_sound_sphere_app.components.DetailsTitleText
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
        ContentEventDetails(viewModel.state, viewModel)
    }
}

@Composable
fun ContentEventDetails(eventState: EventState, viewModel: EventViewModel) {
    LazyColumn(modifier = Modifier
        .padding(10.dp, 80.dp, 10.dp, 10.dp)
        .fillMaxWidth(),
    ) {
        item {
            Column(//modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ImageEventDetailViews(viewModel.state)

                EventDetails(eventState)

                // EventTicketStoreWebsite(eventState)

                // Text(text = "Direction: ${eventState.direction}")
                // Text(text = "Marker: ${eventState.marker}")
            }
        }
    }
}

/*
CUIDADO AL IMPLEMENTAR PETA LA APP

@Composable
fun EventTicketStoreWebsite(eventState: EventState) {
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(eventState.ticketStore))
        context.startActivity(intent)
    }) {
        Text(text = "Open URL")
    }
}
 */

@Composable
fun ImageEventDetailViews(eventState: EventState) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(10.dp)),
        model = eventState.image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun EventDetails(eventState: EventState) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row{
            DetailsTitleText("Fecha: ",false, modifier = Modifier, Color.Black)
            DetailsText(eventState.date)
        }

        Column(
            modifier = Modifier.padding(bottom = 5.dp),
        ) {
            DetailsTitleText(
                text = "Descripción:",
                false,
                modifier = Modifier.padding(bottom = 10.dp),
                color = Color.Black
            )
            DetailsText(eventState.description)
        }

        DetailsTitleText(
            text = "Más Información: ",
            textDecoration = false,
            modifier = Modifier.padding(bottom = 5.dp),
            color = Color.Black
        )

        Row{
            DetailsTitleText("Hora: ",false, modifier = Modifier, Color.Black)
            DetailsText(eventState.time)
        }

        Row{
            DetailsTitleText("Aforo: ", false, modifier = Modifier, Color.Black)
            DetailsText(eventState.capacity.toString())
        }
    }
}