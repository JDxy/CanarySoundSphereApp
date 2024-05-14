package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.project.canary_sound_sphere_app.components.CustomTextButton
import com.project.canary_sound_sphere_app.components.DetailsText
import com.project.canary_sound_sphere_app.components.TitleText
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.model.EventItem
import com.project.canary_sound_sphere_app.ui.theme.backgroundColor
import com.project.canary_sound_sphere_app.ui.theme.itemsAuthorBackgroundColor
import com.project.canary_sound_sphere_app.ui.theme.itemsEventBackgroundColor
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

@Composable
fun EventList(navController: NavController, events: List<EventItem>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(events) { event ->
            eventItem(
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
fun eventItem(id: String, logo: String, name: String, date: String, time: String, capacity: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(400.dp)
            .height(200.dp)
            .background(itemsEventBackgroundColor)
            .clickable {
                navController.navigate("EventDetailScreen")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
      AsyncImage(
            modifier = Modifier
                .width(180.dp)
                .height(180.dp)
                .padding(start = 10.dp)
                .drawWithContent {
                    // Aplicar gradiente de transparencia
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 600f,
                            endY = 750f,
                        ),
                        blendMode = BlendMode.DstOut
                    )
                },
            model = logo,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .width(250.dp)
                .height(180.dp)
                .padding(start = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TitleText(name, true)
            DetailsText("Fecha: $date")
            DetailsText("Horario: $time")
            DetailsText("Aforo: $capacity")
        }
    }
}

@Composable
fun AuthorList(navController: NavController, authors: List<AuthorItem>) {
    LazyColumn(
        modifier = Modifier.padding(top = 80.dp)
    ) {
        items(authors) { author ->
            AuthorItem(author.name, author.image ,navController = navController)
        }
    }
}

@Composable
fun AuthorItem(authorName: String, image: String, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .width(400.dp)
            .height(150.dp)
            .background(itemsAuthorBackgroundColor)
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
            TitleText(authorName, false)
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
