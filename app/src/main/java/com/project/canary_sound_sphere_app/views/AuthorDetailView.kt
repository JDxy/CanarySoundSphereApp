import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.project.canary_sound_sphere_app.components.DetailTopBar
import com.project.canary_sound_sphere_app.components.DetailsText
import com.project.canary_sound_sphere_app.components.DetailsTitleText
import com.project.canary_sound_sphere_app.state.AuthorState
import com.project.canary_sound_sphere_app.ui.theme.blackWithOpacity
import com.project.canary_sound_sphere_app.ui.theme.blueGreen
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            ContentAuthorDetails(viewModel.state, viewModel)
        }
    }
}

@Composable
fun ContentAuthorDetails(authorState: AuthorState, viewModel: AuthorViewModel) {
    LazyColumn(modifier = Modifier
        .padding(10.dp, 80.dp, 10.dp, 10.dp)
        .fillMaxWidth(),
    ) {
        item {
            Column(//modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ImageAuthorDetailViews(viewModel.state)

                AuthorDetails(authorState)

                Box(modifier = Modifier.align(alignment = Alignment.Start)){ AuthorWebsite(authorState) }
            }
        }
    }
}

@Composable
fun ImageAuthorDetailViews(authorState: AuthorState) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(10.dp)),
        model = authorState.image,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun AuthorDetails(authorState: AuthorState) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Column(
            modifier = Modifier.padding(bottom = 5.dp),
        ) {
            DetailsTitleText(
                text = "Género Musical:",
                false,
                modifier = Modifier.padding(bottom = 10.dp),
                color = Color.Black
            )
            DetailsText(authorState.music_type)
        }

        Column(
            modifier = Modifier.padding(bottom = 5.dp),
        ) {
            DetailsTitleText(
                text = "Descripción:",
                false,
                modifier = Modifier.padding(bottom = 10.dp),
                color = Color.Black
            )
            DetailsText(authorState.description)
        }

        Row{
            DetailsTitleText("Periodo de actividad: ",false, modifier = Modifier, Color.Black)
            DetailsText(authorState.foundation_year)
        }
    }
}

@Composable
fun AuthorWebsite(authorState: AuthorState){
    val context= LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authorState.music_list))
    Button(
        onClick = {context.startActivity(intent)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(blueGreen)
    ) {
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = "Listas de Reproducción",
            tint = blackWithOpacity,
            modifier = Modifier.padding(end = 8.dp),
        )
        Text("Listas de Reproducción",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = blackWithOpacity,
            style = TextStyle(  fontStyle = FontStyle.Normal )
        )
    }
}