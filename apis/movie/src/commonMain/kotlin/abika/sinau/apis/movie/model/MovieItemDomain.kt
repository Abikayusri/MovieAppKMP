package abika.sinau.apis.movie.model

data class MovieItemDomain(
    val id: Int,
    val overview: String,
    val title: String,
    val backdropPath: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val releaseDate: String
)
