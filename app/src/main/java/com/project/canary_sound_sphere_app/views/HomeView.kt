package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.project.canary_sound_sphere_app.components.detailsText
import com.project.canary_sound_sphere_app.components.titleText
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.model.EventItem
import com.project.canary_sound_sphere_app.ui.theme.backgroundColor
import com.project.canary_sound_sphere_app.ui.theme.itemsBackgroundColor
import com.project.canary_sound_sphere_app.ui.theme.menuColor
import com.project.canary_sound_sphere_app.ui.theme.titleColor
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

@Composable
fun EventList(navController: NavController, events: List<EventItem>) {
    LazyColumn(
        modifier = Modifier.padding(top = 80.dp)
    ) {
        items(events) { event ->
            eventItem(
                eventName = event.name,
                days = event.date,
                hours = event.time,
                capacity = event.capacity.toString(),
                navController = navController
            )
        }
    }
}

@Composable
fun AuthorList(navController: NavController, authors: List<AuthorItem>) {
    LazyColumn(
        modifier = Modifier.padding(top = 80.dp)
    ) {
        items(authors) { author ->
            authorItem(author.name, author.image ,navController = navController)
        }
    }
}


@Composable
fun eventItem(eventName: String, days: String, hours: String, capacity: String, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .width(400.dp)
            .height(150.dp)
            .background(itemsBackgroundColor)
            .clickable {
                navController.navigate("EventDetailScreen")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://github.com/JDxy/Canary-Sphere-Sound-App-Images/blob/main/15502681_1575153519168344_856285858_o-1-1287306393.jpg?raw=tru"),
            contentDescription = "Imagen del evento",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Column(
            modifier = Modifier
                .width(200.dp),
            horizontalAlignment = Alignment.Start

            ) {
            titleText(eventName)
            detailsText("Días: $days")
            detailsText("Horario: $hours")
            detailsText("Aforo: $capacity")
        }
    }
}


@Composable
fun authorItem(authorName: String, image: String, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .width(400.dp)
            .height(150.dp)
            .background(itemsBackgroundColor)
            .clickable {
                navController.navigate("AuthorDetailScreen")

            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "Imagen del evento",
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Column(
            modifier = Modifier
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            titleText(authorName)
        }
    }
}


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
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        onEventsClicked()
                    },
                    modifier = Modifier
                        .weight(30F)
                        .padding(end = 4.dp),
                    content = {
                        Text(
                            text = "Eventos",
                            color = if (isEventsSelected) titleColor else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp
                        )
                    }
                )
                IconButton(
                    onClick = {
                        onAuthorsClicked()
                    },
                    modifier = Modifier
                        .weight(30F)
                        .padding(start = 4.dp),
                    content = {
                        Text(
                            text = "Autores",
                            color = if (isAuthorsSelected) titleColor else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp
                        )
                    }
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = menuColor
        )
    )
}
