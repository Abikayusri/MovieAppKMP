package abika.sinau.apis.movie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform