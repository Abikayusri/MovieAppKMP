package abika.sinau.libraries.core

import androidx.compose.runtime.compositionLocalOf

interface AppConfig {
    val baseUrl: String
    val apiKey: String
}

val LocalAppConfig = compositionLocalOf<AppConfig> { error("App Config not provided") }