package abika.sinau.libraries.component.ui

import abika.sinau.libraries.component.utils.LocalImageResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTopBar(
    title: String,
    enableElevation: Boolean = true,
    actionBack: (() -> Unit)? = null
) {
    val imageResources = LocalImageResource.current
    val elevation = remember {
        if (enableElevation) 6.dp else 0.dp
    }
    TopAppBar(
        contentColor = Color.Black,
        backgroundColor = Color.White,
        elevation = elevation
    ) {
        if (actionBack != null) {
            IconButton(
                onClick = {
                    actionBack.invoke()
                }
            ) {
                Icon(
                    painter = imageResources.ArrowBack(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.size(24.dp))
        }
        Text(
            text = title
        )
    }
}