package com.project.canary_sound_sphere_app.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.viewModel.ViewModel

@Composable
fun DetailView(viewModel: ViewModel, navController: NavController, id:Int){
    /*
    LaunchedEffect(Unit){
        viewModel.getPokeById(id)
    }
    Scaffold(
        topBar= {
            MainTopBar(title = viewModel.state.name, showBackButton = true) {
                navController.popBackStack()
            }
        }
    ){
        //ContenDetailView(pad = it, viewModel = viewModel)
    }

     */

}