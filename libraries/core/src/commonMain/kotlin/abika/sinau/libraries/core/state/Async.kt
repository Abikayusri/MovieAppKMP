package abika.sinau.libraries.core.state

sealed class Async<out T> {
    data object Default : Async<Nothing>()
    data object Loading : Async<Nothing>()
    data class Success<T>(val data: T) : Async<T>()
    data class Failure(val throwable: Throwable) : Async<Nothing>()
}