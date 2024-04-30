package com.project.canary_sound_sphere_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.canary_sound_sphere_app.viewModel.ViewModel
import com.project.canary_sound_sphere_app.views.HomeView

@Composable
fun NavManager(viewModel: ViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeView(viewModel, navController)
        }
    }
}