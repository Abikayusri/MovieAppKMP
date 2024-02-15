package abika.sinau.apis.movie.datasources

import abika.sinau.libraries.core.AppConfig
import abika.sinau.libraries.core.network.NetworkDataSources
import co.touchlab.kermit.Logger
import io.ktor.client.statement.HttpResponse

class MovieDataSources(
    private val appConfig: AppConfig,
) : NetworkDataSources(appConfig.baseUrl) {

    suspend fun getPopularMovie(query: String?): HttpResponse {
        val endPoint: String = if (query == null) {
            "movie/popular"
        } else {
            "movie/popular&query=$query"
        }
        Logger.d("Testing: $endPoint")
        return getHttpResponse(endPoint)
    }

    suspend fun getUpComingMovie(query: String): HttpResponse {
        val endPoint = "movie/upcoming$query"
        return getHttpResponse(endPoint)
    }
}