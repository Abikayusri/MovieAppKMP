package abika.sinau.libraries.component.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.painter.Painter

interface ImageResources {

    @Composable
    fun ArrowBack(): Painter

    @Composable
    fun StarFill(): Painter

    @Composable
    fun StarBorder(): Painter
}

val LocalImageResource = compositionLocalOf<ImageResources> { error("Image resource not provided") }