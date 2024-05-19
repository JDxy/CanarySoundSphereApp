package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.model.AuthorItem

@Composable
fun AuthorList(navController: NavController, authors: List<AuthorItem>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 160.dp)
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
    logo: String,
    onClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .clickable { onClick(id) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        TitleText(
            modifier = Modifier.align(alignment = Alignment.Start),
            style = TextStyle(),
            text = name,
            textDecoration =  false,
            color = Color.Black)
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(3f / 2f)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White),
            onClick = { onClick(id) }
        ) {
            ImageHomeComponent(logo)
        }
    }
}