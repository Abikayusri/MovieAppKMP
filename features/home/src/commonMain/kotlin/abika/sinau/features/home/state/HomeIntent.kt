package abika.sinau.features.home.state

import abika.sinau.libraries.core.state.Intent
import androidx.compose.material.SnackbarHostState
import kotlinx.coroutines.CoroutineScope

sealed class HomeIntent : Intent {
    data object GetPopularMovie : HomeIntent()
    data object GetUpcomingMovie : HomeIntent()
    data class ShowSnackbar(
        val name: String,
        val snackbarState: SnackbarHostState,
        val coroutineScope: CoroutineScope,
    ) : HomeIntent()
}