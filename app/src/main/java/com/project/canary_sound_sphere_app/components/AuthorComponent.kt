package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.model.AuthorItem
import com.project.canary_sound_sphere_app.ui.theme.utOrange

@Composable
fun AuthorList(navController: NavController, authors: List<AuthorItem>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 74.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
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
    Column(
        modifier = Modifier
            .width(360.dp)
            .height(280.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(utOrange)
            .clickable { onClick(id) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AuthorDetails(name, image)
    }
}
@Composable
fun AuthorDetails(name: String, image: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 10.dp, 25.dp, 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(name, false,
            Modifier
                .align(alignment = Alignment.CenterHorizontally),
            Color.Black
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        ImageHomeComponent(image)
    }
}