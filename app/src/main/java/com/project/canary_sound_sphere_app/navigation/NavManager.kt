package com.project.canary_sound_sphere_app.navigation

import AuthorDetailView
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel
import com.project.canary_sound_sphere_app.views.HomeView
import com.project.canary_sound_sphere_app.views.EventDetailView

@Composable
fun NavManager(eventViewModel: EventViewModel, authorViewModel: AuthorViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeView(eventViewModel, authorViewModel, navController)
        }

        composable("EventDetailScreen/{id}", arguments= listOf(
            navArgument("id"){
                type= NavType.StringType
            }
        )){
            val id = it.arguments?.getString("id")?:0
            EventDetailView(eventViewModel, navController, id.toString())
        }

        composable("AuthorDetailScreen/{id}", arguments= listOf(
            navArgument("id"){
                type= NavType.StringType
            }
        )){
            val id = it.arguments?.getString("id") ?: ""
            AuthorDetailView(authorViewModel, navController, id)
        }

    }
}
