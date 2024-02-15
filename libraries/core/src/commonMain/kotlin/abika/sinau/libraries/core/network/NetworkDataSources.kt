package abika.sinau.libraries.core.network

import abika.sinau.movieapp.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class NetworkDataSources(
    private val baseUrl: String,
) {

    suspend fun getHttpResponse(endPoint: String): HttpResponse {
        val url = "$baseUrl$endPoint"
        val client = client.get(url) {
            parameter("api_key", BuildKonfig.API_KEY)
            contentType(ContentType.Application.Json)
        }
        return client
    }

    suspend fun postHttpResponse(endPoint: String, body: Any): HttpResponse {
        val url = "$baseUrl$endPoint"
        return client.post(url) {
            setBody(body)
            parameter("api_key", BuildKonfig.API_KEY)
            contentType(ContentType.Application.Json)
        }
    }

    companion object {
        private val client: HttpClient by lazy {
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        json = Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.BODY
                }
            }
        }
    }
}