package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.model.EventItem
import com.project.canary_sound_sphere_app.ui.theme.colorCardText
import com.project.canary_sound_sphere_app.ui.theme.itemsEventBackgroundColor

@Composable
fun EventList(navController: NavController, events: List<EventItem>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        items(events) { event ->
            EventItem(
                id=event.id,
                logo=event.logo,
                name=event.name,
                date=event.date,
                time=event.time,
                capacity=event.capacity,
                navController = navController
            )
        }
    }
}

@Composable
fun EventItem(
    id: String,
    logo: String,
    name: String,
    date: String,
    time: String,
    capacity: Int,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(400.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(itemsEventBackgroundColor)
            .border(
                BorderStroke(1.dp, colorCardText),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { navController.navigate("EventDetailScreen") },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        EventLogo(logo)
        EventDetails(name, date, time, capacity)
    }
}

@Composable
fun EventLogo(logo: String) {
    AsyncImage(
        modifier = Modifier
            .width(200.dp)
            .height(170.dp)
            .padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                BorderStroke(1.dp, colorCardText),
                shape = RoundedCornerShape(8.dp)
            ),
        model = logo,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun EventDetails(name: String, date: String, time: String, capacity: Int) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(170.dp)
            .padding(start = 0.dp, top = 6.dp, end = 14.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(name, true)
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        DetailsText("Fecha: $date")
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        DetailsText("Horario: $time")
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        DetailsText("Aforo: $capacity")
    }
}