package abika.sinau.features.home.state

import abika.sinau.apis.movie.model.MovieItemDomain
import abika.sinau.libraries.core.state.Async

data class HomeState(
    val appName: String = "",
    val asyncPopularMovieList: Async<List<MovieItemDomain>> = Async.Default,
    val asyncUpcomingMovieList: Async<List<MovieItemDomain>> = Async.Default,
)