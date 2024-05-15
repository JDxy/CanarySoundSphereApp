package com.project.canary_sound_sphere_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.project.canary_sound_sphere_app.ui.theme.colorCardText

@Composable
fun TitleText(text: String, textDecoration: Boolean) {
    Text(
        text = text,
        color = colorCardText,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = if(textDecoration) TextDecoration.Underline else TextDecoration.None,
        softWrap = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DetailsText(text: String){
    Text(
        text = text,
        color = colorCardText,
        fontSize = 14.sp,
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
    fontSize: Float = 20f,
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
            containerColor = menuColor
        ),
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },

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