package com.project.canary_sound_sphere_app.views

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.components.AuthorList
import com.project.canary_sound_sphere_app.components.CustomTextButton
import com.project.canary_sound_sphere_app.components.EventList
import com.project.canary_sound_sphere_app.ui.theme.blackWithOpacity
import com.project.canary_sound_sphere_app.ui.theme.blackWithSoftOpacity
import com.project.canary_sound_sphere_app.ui.theme.selectiveYellow
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    eventViewModel: EventViewModel,
    authorViewModel: AuthorViewModel,
    navController: NavController
) {
    val events by eventViewModel.events.collectAsState()
    val authors by authorViewModel.authors.collectAsState()
    var isEventsSelected by remember { mutableStateOf(true) }
    var isAuthorsSelected by remember { mutableStateOf(false) }
    var isMenuVisible by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.background(Color.White),
        topBar = {
            MainTopBar(
                isEventsSelected = isEventsSelected,
                isAuthorsSelected = isAuthorsSelected,
                isMenuVisible = isMenuVisible,
                onMenuClicked = { isMenuVisible = !isMenuVisible },
                onEventsClicked = {
                    isEventsSelected = true
                    isAuthorsSelected = false
                    isMenuVisible = false
                },
                onAuthorsClicked = {
                    isEventsSelected = false
                    isAuthorsSelected = true
                    isMenuVisible = false
                },
                searchText = searchText,
                onSearchTextChanged = { searchText = it }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            if (isEventsSelected) {
                EventList(navController, events.filter { it.name.contains(searchText, ignoreCase = true) })
            } else if (isAuthorsSelected) {
                AuthorList(navController, authors.filter { it.name.contains(searchText, ignoreCase = true) })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    isEventsSelected: Boolean,
    isAuthorsSelected: Boolean,
    isMenuVisible: Boolean,
    onMenuClicked: () -> Unit,
    onEventsClicked: () -> Unit,
    onAuthorsClicked: () -> Unit,
    searchText: String,
    onSearchTextChanged: (String) -> Unit
) {

    Column {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = onMenuClicked, modifier = Modifier.padding(start = 8.dp)) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = blackWithOpacity
            )
        )

        Divider(color = Color.Gray, thickness = 1.dp)

        AnimatedVisibility(
            visible = isMenuVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(blackWithOpacity),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextButton(
                    text = "EVENTOS",
                    isSelected = isEventsSelected,
                    textColor = if(isEventsSelected) selectiveYellow else
                        Color.White,
                    onClick = onEventsClicked
                )

                CustomTextButton(
                    text = "AUTORES",
                    isSelected = isAuthorsSelected,
                    textColor = if(isAuthorsSelected) selectiveYellow else
                        Color.White,
                    onClick = onAuthorsClicked
                )
            }
        }

        Box(
            modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 20.dp)
        ){
            SearchComponent(searchText = searchText, onSearchTextChanged = onSearchTextChanged)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    searchText: String,
    onSearchTextChanged: (String) -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }

    Box {
        TextField(
            value = searchText,
            onValueChange = {
                onSearchTextChanged(it)
                isFocused = true
            },
            colors = TextFieldDefaults.textFieldColors(containerColor = blackWithSoftOpacity),
            textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Normal, fontSize = 16.sp),
            modifier = Modifier
                .width(370.dp)
                .border(1.dp, Color.Gray)
                .onFocusChanged { focusState -> isFocused = focusState.isFocused },
            trailingIcon = {
                if (isFocused && searchText.isNotEmpty()) {
                    IconButton(onClick = { onSearchTextChanged("") }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.White)
                    }
                }
            }
        )

        if (!isFocused || searchText.isEmpty()) {
            Text(
                text = "Buscar...",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 8.dp)
                    .clickable { isFocused = true }
            )
        }
    }
}