package abika.sinau.libraries.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform