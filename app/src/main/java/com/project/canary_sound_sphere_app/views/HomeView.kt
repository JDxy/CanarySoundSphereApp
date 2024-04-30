package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.util.Constants
import com.project.canary_sound_sphere_app.viewModel.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(viewModel: ViewModel, navController: NavController) {
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
            }
        )
    {
        Column {
            Text(text = "Contenido de Eventos", color = Color.Black)
            if (isEventsSelected) {
                Text(text = "Contenido de Eventos", color = Color.Black)
            } else if (isAuthorsSelected) {
                Text(text = "Contenido de Autores", color = Color.Black)
            }
        }
    }

}
/*
@Composable
fun EventList() {
    LazyColumn {

        }
    }
}

 */

@Composable
fun EventItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(
                text = "pokemon.name",
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "pokemon.formatId",
            )
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
    showBackButton: Boolean = false
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
                            color = if (isEventsSelected) Color.Green else Color.White,
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
                            color = if (isAuthorsSelected) Color.Green else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp
                        )
                    }
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(Constants.CUSTOM_BLACK)
        ),
        navigationIcon = {
            /*
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

             */
        }
    )
}
