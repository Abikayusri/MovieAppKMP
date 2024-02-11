package abika.sinau.features.home

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform