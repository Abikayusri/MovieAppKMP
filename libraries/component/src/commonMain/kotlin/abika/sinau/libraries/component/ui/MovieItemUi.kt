package abika.sinau.libraries.component.ui

import abika.sinau.apis.movie.model.MovieItemDomain
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter

@Composable
fun MovieItemGridScreen(
    movieItem: MovieItemDomain,
    onItemClick: (MovieItemDomain) -> Unit,
) {
    val imagePainter = rememberImagePainter(movieItem.posterPath)

    Card(
        modifier = Modifier
            .padding(6.dp)
            .height(180.dp)
            .aspectRatio(1 / 1.7f)
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(6.dp)
            )
            .clickable {
                onItemClick.invoke(movieItem)
            }
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .background(
                        color = Color.Blue.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(topEnd = 6.dp, topStart = 6.dp)
                    )
            ) {

                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(topEnd = 6.dp, topStart = 6.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = movieItem.voteAverage.toString(),
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .padding(6.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 6.dp)
                    )
                    .weight(0.5f)
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Text(
                    text = movieItem.title,
                    fontSize = 12.sp
                )
                Text(
                    text = movieItem.overview,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Composable
fun MovieItemVerticalScreen(
    movieItem: MovieItemDomain,
    onItemClick: (MovieItemDomain) -> Unit,
) {
    val imagePainter = rememberImagePainter(movieItem.posterPath)

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(6.dp)
            )
            .clickable {
                onItemClick.invoke(movieItem)
            }
    ) {
        Row(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .weight(0.5f)
                    .background(
                        color = Color.Blue.copy(alpha = 0.3f)
                    )
            ) {

                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = movieItem.voteAverage.toString(),
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .padding(6.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 6.dp)
                    )
                    .weight(0.5f)
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Text(
                    text = movieItem.title,
                    fontSize = 12.sp
                )
                Text(
                    text = movieItem.overview,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}