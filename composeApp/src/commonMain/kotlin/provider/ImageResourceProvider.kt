package provider

import abika.sinau.libraries.component.utils.ImageResources
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
class ImageResourceProvider : ImageResources {

    @Composable
    override fun ArrowBack(): Painter {
        return painterResource("round_arrow_back_24.xml")
    }

    @Composable
    override fun StarFill(): Painter {
        return painterResource("round_star_24.xml")
    }

    @Composable
    override fun StarBorder(): Painter {
        return painterResource("round_star_border_24.xml")
    }
}