package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.ui.theme.colorCardText
import com.project.canary_sound_sphere_app.ui.theme.itemsAuthorBackgroundColor

@Composable
fun AuthorList(navController: NavController, authors: List<AuthorItem>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
        ) {
        items(authors) { author ->
            AuthorItem(
                author.id,
                author.name,
                author.image,
                onClick = { authorId ->
                    navController.navigate("AuthorDetailScreen/$authorId")
                }
            )
        }
    }
}

@Composable
fun AuthorItem(
    id: String,
    name: String,
    image: String,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(400.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(itemsAuthorBackgroundColor)
            .border(
                BorderStroke(1.dp, colorCardText),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick(id) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AuthorLogo(image = image)
        AuthorDetails(name = name)
    }
}

@Composable
fun AuthorLogo(image: String) {
    AsyncImage(
        modifier = Modifier
            .width(250.dp)
            .height(170.dp)
            .padding(start = 14.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                BorderStroke(1.dp, colorCardText),
                shape = RoundedCornerShape(8.dp)
            ),
        model = image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun AuthorDetails(name: String) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(start = 10.dp, top = 6.dp, end = 14.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(name, false)
    }
}