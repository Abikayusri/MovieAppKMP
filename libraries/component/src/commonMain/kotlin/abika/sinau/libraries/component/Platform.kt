package abika.sinau.libraries.component

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform