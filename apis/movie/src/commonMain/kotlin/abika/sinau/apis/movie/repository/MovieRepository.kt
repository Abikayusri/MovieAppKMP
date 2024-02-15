package abika.sinau.apis.movie.repository

import abika.sinau.apis.movie.datasources.MovieDataSources
import abika.sinau.apis.movie.model.MovieItemDomain
import abika.sinau.apis.movie.model.MovieListResponse
import abika.sinau.libraries.core.AppConfig
import abika.sinau.libraries.core.repository.BaseRepository
import abika.sinau.libraries.core.state.Async
import androidx.compose.runtime.compositionLocalOf
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val appConfig: AppConfig,
) : BaseRepository() {
    private val dataSources by lazy { MovieDataSources(appConfig) }

    fun getPopularMovie(query: String? = null): Flow<Async<List<MovieItemDomain>>> {
        return suspend {
            dataSources.getPopularMovie(query)
        }.reduce<MovieListResponse, List<MovieItemDomain>> { response ->
            val responseData = response.results

            if (responseData.isNullOrEmpty()) {
                val throwable = Throwable("Movie is empty")
                Async.Failure(throwable)
            } else {
                val data = response.toMovieDomain()
                Async.Success(data)
            }
        }
    }
}

val LocalMovieRepository =
    compositionLocalOf<MovieRepository> { error("Movie repository not provided!") }