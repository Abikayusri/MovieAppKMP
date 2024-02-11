package abika.sinau.features.favorite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform