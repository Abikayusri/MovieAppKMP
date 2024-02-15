package abika.sinau.features.home.screen

import abika.sinau.apis.movie.model.MovieItemDomain
import abika.sinau.features.home.state.HomeState
import abika.sinau.libraries.component.ui.FailureScreen
import abika.sinau.libraries.component.ui.LoadingScreen
import abika.sinau.libraries.component.ui.MovieItemGridScreen
import abika.sinau.libraries.core.state.Async
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PopularMovieSection(
    homeState: HomeState,
    onItemClick: (MovieItemDomain) -> Unit,
    tryAgainAction: () -> Unit,
) {

    Row(
        modifier = Modifier.padding(horizontal = 12.dp)
            .padding(top = 12.dp)
    ) {
        Text(
            text = "Top Products"
        )
    }

    when (val async = homeState.asyncPopularMovieList) {
        is Async.Loading -> {
            LoadingScreen()
        }

        is Async.Success -> {
            val products = async.data
            LazyRow(
                contentPadding = PaddingValues(6.dp)
            ) {
                items(products) {
                    MovieItemGridScreen(
                        movieItem = it,
                        onItemClick = onItemClick
                    )
                }
            }
        }

        is Async.Failure -> {
            val message = async.throwable.message.orEmpty()
            FailureScreen(message, tryAgainAction)
        }

        else -> {}
    }
}