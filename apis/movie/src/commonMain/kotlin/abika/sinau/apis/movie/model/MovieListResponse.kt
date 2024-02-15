package abika.sinau.apis.movie.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    @SerialName("dates")
    val dates: Dates? = null,
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<Result>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null,
) {
    @Serializable
    data class Dates(
        @SerialName("maximum")
        val maximum: String? = null,
        @SerialName("minimum")
        val minimum: String? = null,
    )

    @Serializable
    data class Result(
        @SerialName("adult")
        val adult: Boolean? = null,
        @SerialName("backdrop_path")
        val backdropPath: String? = null,
        @SerialName("genre_ids")
        val genreIds: List<Int?>? = null,
        @SerialName("id")
        val id: Int? = null,
        @SerialName("original_language")
        val originalLanguage: String? = null,
        @SerialName("original_title")
        val originalTitle: String? = null,
        @SerialName("overview")
        val overview: String? = null,
        @SerialName("popularity")
        val popularity: Double? = null,
        @SerialName("poster_path")
        val posterPath: String? = null,
        @SerialName("release_date")
        val releaseDate: String? = null,
        @SerialName("title")
        val title: String? = null,
        @SerialName("video")
        val video: Boolean? = null,
        @SerialName("vote_average")
        val voteAverage: Double? = null,
        @SerialName("vote_count")
        val voteCount: Int? = null,
    ) {
        fun toDomain(): MovieItemDomain {
            return MovieItemDomain(
                id = id ?: 0,
                overview = overview.orEmpty(),
                title = title.orEmpty(),
                backdropPath = backdropPath.orEmpty(),
                posterPath = posterPath.orEmpty(),
                voteAverage = voteAverage ?: 0.0,
                voteCount = voteCount ?: 0,
                releaseDate = releaseDate.orEmpty()
            )
        }
    }

    fun toMovieDomain(): List<MovieItemDomain> {
        return results?.map { it.toDomain() }.orEmpty()
    }
}