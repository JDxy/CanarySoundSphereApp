package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.project.canary_sound_sphere_app.components.DetailTopBar
import com.project.canary_sound_sphere_app.components.DetailsText
import com.project.canary_sound_sphere_app.components.DetailsTitleText
import com.project.canary_sound_sphere_app.state.EventState
import com.project.canary_sound_sphere_app.ui.theme.blackWithOpacity
import com.project.canary_sound_sphere_app.ui.theme.utOrange
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            ContentEventDetails(viewModel.state, viewModel)
        }
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
                if (viewModel.state.marker.isNotBlank()) {
                    val cords = viewModel.state.marker
                    val parts = cords.split(", ")
                    val latitude = parts[0].toDouble()
                    val longitude = parts[1].toDouble()
                    MyGoogleMaps(latitude, longitude, true)
                }
                DetailsText(viewModel.state.direction)
                Box(modifier = Modifier.align(alignment = Alignment.Start)){EventWebsite(eventState)}
            }
        }
    }
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

@Composable
fun MyGoogleMaps(latitude: Double, longitude: Double, clearMap: Boolean) {
    val latLng = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 20f)
    }
    val properties = remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
    val uiSettings = remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }
    val rotateSettings = remember { mutableStateOf(MapUiSettings(scrollGesturesEnabled = true)) }

    if (clearMap) {
        cameraPositionState.position = CameraPosition.fromLatLngZoom(latLng, 10f)
        properties.value = MapProperties(mapType = MapType.NORMAL)
        uiSettings.value = MapUiSettings(zoomControlsEnabled = true)
        rotateSettings.value = MapUiSettings(scrollGesturesEnabled = true)
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp)),
        cameraPositionState = cameraPositionState,
        properties = properties.value,
        uiSettings = uiSettings.value
    ) {
        Marker(
            state = MarkerState(position = latLng),
            title = "One Marker"
        )
    }
}

@Composable
fun EventWebsite(eventState: EventState){
    val context= LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(eventState.ticketStore))
      Button(
          onClick = {context.startActivity(intent)},
          modifier = Modifier
              .fillMaxWidth()
              .padding(5.dp),
          colors = ButtonDefaults.buttonColors(utOrange)
      ) {
          Icon(
              imageVector = Icons.Filled.ShoppingCart,
              contentDescription = "Comprar Tickets",
              tint = blackWithOpacity,
              modifier = Modifier.padding(end = 8.dp),
              )
          Text("Comprar Tickets",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = blackWithOpacity,
              style = TextStyle(  fontStyle = FontStyle.Normal )
          )
      }
}

@Composable
fun ImageEventDetailViews(eventState: EventState) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(10.dp)),
        model = eventState.image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}