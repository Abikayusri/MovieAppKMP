package abika.sinau.features.home.viewmodel

import abika.sinau.apis.movie.repository.MovieRepository
import abika.sinau.features.home.state.HomeIntent
import abika.sinau.features.home.state.HomeState
import abika.sinau.libraries.core.state.Intent
import abika.sinau.libraries.core.viewmodel.ViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieRepository: MovieRepository,
) : ViewModel<HomeState, HomeIntent>(HomeState()) {

    init {
        sendIntent(HomeIntent.GetPopularMovie)
    }

    override fun sendIntent(intent: Intent) {
        when (intent) {
            is HomeIntent.GetPopularMovie -> {
                getPopularMovieList()
            }

            is HomeIntent.GetUpcomingMovie -> {

            }

            is HomeIntent.ShowSnackbar -> {
                intent.coroutineScope.launch {
                    intent.snackbarState.showSnackbar(intent.name)
                }
            }
        }
    }

    private fun getPopularMovieList() = viewModelScope.launch {
        movieRepository.getPopularMovie()
            .stateIn(this)
            .collectLatest {
                updateUiState {
                    copy(
                        asyncPopularMovieList = it
                    )
                }
            }
    }
}