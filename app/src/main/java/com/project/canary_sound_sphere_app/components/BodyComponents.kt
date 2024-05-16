package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.project.canary_sound_sphere_app.ui.theme.menuColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.ui.theme.prussianBlue

@Composable
fun TitleText(text: String, textDecoration: Boolean, modifier: Modifier,  fontSize: TextUnit) {
    Text(
        text = text,
        color = prussianBlue,
        fontSize = fontSize,
        fontWeight = FontWeight.W900,
        textDecoration = if(textDecoration) TextDecoration.Underline else TextDecoration.None,
        softWrap = true,
        modifier = modifier
    )
}
@Composable
fun DetailsText(text: String, fontSize: TextUnit){
    Text(text = text,
        color = prussianBlue,
        fontSize = fontSize,
        fontWeight = FontWeight.Normal,
        softWrap = true,
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Composable que representa un botón de texto personalizado. *
 * @param modifier
 * @param text
 * @param textColor
 * @param fontWeight
 * @param fontSize
 * @param isSelected
 * @param onClick
 */
@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: Float = 22f,
    isSelected: Boolean,
    onClick: () -> Unit
    ) {
    Text(
        modifier = modifier
            .padding(18.dp)
            .clickable { onClick() },
        text = text,
        color = textColor,
        textDecoration = if (isSelected) TextDecoration.Underline else TextDecoration.None,
        fontWeight = fontWeight,
        fontSize = fontSize.sp
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
            containerColor = Color.Transparent
        ),
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },

        navigationIcon = {

            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
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
            .width(360.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(20.dp)),
        model = image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}