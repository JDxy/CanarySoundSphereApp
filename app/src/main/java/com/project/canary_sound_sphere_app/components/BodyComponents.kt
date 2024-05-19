package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.ui.theme.Montserrat
import com.project.canary_sound_sphere_app.ui.theme.blackWithOpacity

@Composable
fun TitleText(modifier: Modifier, style :TextStyle, text: String, textDecoration: Boolean, color: Color) {
    Text(
        modifier = modifier,
        style = style,
        text = text,
        color = color,
        fontSize = 18.sp,
        textDecoration = if(textDecoration) TextDecoration.Underline else TextDecoration.None,
        softWrap = true,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal
    )
}
@Composable
fun DetailsTitleText(text: String, textDecoration: Boolean, modifier: Modifier, color: Color) {
    Text(
        text = text,
        color = color,
        fontSize = 16.sp,
        textDecoration = if(textDecoration) TextDecoration.Underline else TextDecoration.None,
        softWrap = true,
        modifier = modifier,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun DetailsText(text: String){
    Text(text = text,
        color = Color.Black,
        fontSize = 16.sp,
        softWrap = true,
        modifier = Modifier.fillMaxWidth(),
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal
    )
}
/**
 * Composable que representa un botón de texto personalizado. *
 * @param modifier
 * @param text
 * @param textColor
 * @param isSelected
 * @param onClick
 */
@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .padding(top = 55.dp)
            .clickable { onClick() },
        text = text,
        color = textColor,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    title: String,
    navController: NavController,
    showBackButton: Boolean = false
) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = blackWithOpacity
        ),
        title = {
            TitleText(
                modifier = Modifier,
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                ),
                text = title ,
                textDecoration = false,
                color = Color.White )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        }
    )
}
@Composable
fun ImageHomeComponent(image: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        model = image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}