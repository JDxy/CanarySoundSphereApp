package com.project.canary_sound_sphere_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.project.canary_sound_sphere_app.navigation.NavManager
import com.project.canary_sound_sphere_app.ui.theme.CanarySoundSphereAppTheme
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel
import com.project.canary_sound_sphere_app.viewModel.EventViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val eventViewModel: EventViewModel by viewModels()
    private val authorViewModel: AuthorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanarySoundSphereAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(eventViewModel, authorViewModel)
                }
            }
        }
    }
}
