import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.canary_sound_sphere_app.components.DetailTopBar
import com.project.canary_sound_sphere_app.state.AuthorState
import com.project.canary_sound_sphere_app.viewModel.AuthorViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthorDetailView(viewModel: AuthorViewModel, navController: NavController, id: String) {
    LaunchedEffect(Unit) {
        viewModel.getAuthorById(id)
    }
    Scaffold(
        topBar = {
            DetailTopBar(viewModel.state.name, navController, showBackButton = true)
        }
    ) {
        ContentAuthorDetails(viewModel.state)
    }
}

@Composable
fun ContentAuthorDetails(authorState: AuthorState) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 80.dp)
    ) {
        Text(text = "Name: ${authorState.name}")

        Text(text = "Foundation Year: ${authorState.foundation_year}")

        Text(text = "Music Type: ${authorState.music_type}")

        Text(text = "Description: ${authorState.description}")

        Text(text = "Music List: ${authorState.music_list}")
    }
}
