package abika.sinau.features.home.ui

import abika.sinau.apis.movie.model.MovieItemDomain
import abika.sinau.apis.movie.repository.LocalMovieRepository
import abika.sinau.features.home.screen.PopularMovieSection
import abika.sinau.features.home.state.HomeIntent
import abika.sinau.features.home.viewmodel.HomeViewModel
import abika.sinau.libraries.core.viewmodel.rememberViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun Home(
    onPopularMovieClick: (MovieItemDomain) -> Unit,
) {
    val movieRepository = LocalMovieRepository.current
    val movieViewModel = rememberViewModel { HomeViewModel(movieRepository) }

    val movieState by movieViewModel.uiState.collectAsState()

    Column {
        PopularMovieSection(
            homeState = movieState,
            onItemClick = {
                onPopularMovieClick.invoke(it)
            },
            tryAgainAction = {
                movieViewModel.sendIntent(HomeIntent.GetPopularMovie)
            }
        )
    }
}