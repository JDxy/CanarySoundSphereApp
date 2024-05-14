package com.project.canary_sound_sphere_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel
import com.project.canary_sound_sphere_app.views.AuthorDetailView
import com.project.canary_sound_sphere_app.views.HomeView
import com.project.canary_sound_sphere_app.views.EventDetailView

@Composable
fun NavManager(eventViewModel: EventViewModel, authorViewModel: AuthorViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeView(eventViewModel, authorViewModel, navController)
        }
        composable("EventDetailScreen"){
            EventDetailView(eventViewModel, navController)
        }
        composable("AuthorDetailScreen"){
            AuthorDetailView(navController)
        }
    }
}
