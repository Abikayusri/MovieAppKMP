import abika.sinau.apis.movie.repository.LocalMovieRepository
import abika.sinau.apis.movie.repository.MovieRepository
import abika.sinau.features.home.ui.Home
import abika.sinau.libraries.component.utils.LocalImageResource
import abika.sinau.libraries.core.LocalAppConfig
import abika.sinau.libraries.core.viewmodel.LocalViewModelHost
import abika.sinau.libraries.core.viewmodel.ViewModelHost
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import abika.sinau.libraries.core.provider.AppConfigProvider
import provider.ImageResourceProvider

@Composable
fun App() {
    val viewModelHost = remember { ViewModelHost() }
    val appConfigProvider = remember { AppConfigProvider() }
    val imageResourcesProvider = remember { ImageResourceProvider() }

    val movieRepository = remember { MovieRepository(appConfigProvider) }

    CompositionLocalProvider(
        LocalViewModelHost provides viewModelHost,
        LocalAppConfig provides appConfigProvider,
        LocalMovieRepository provides movieRepository,
        LocalImageResource provides imageResourcesProvider,
    ) {
        MaterialTheme {
            Home {
            }
        }
    }

//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        val greeting = remember { Greeting().greet() }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource("compose-multiplatform.xml"), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}