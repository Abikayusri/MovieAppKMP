package abika.sinau.libraries.core.provider

import abika.sinau.libraries.core.AppConfig
import abika.sinau.movieapp.BuildKonfig

class AppConfigProvider : AppConfig {
    override val baseUrl: String
        get() = BuildKonfig.BASE_URL
    override val apiKey: String
        get() = BuildKonfig.API_KEY
}