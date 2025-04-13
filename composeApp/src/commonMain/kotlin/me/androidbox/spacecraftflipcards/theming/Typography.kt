package me.androidbox.spacecraftflipcards.theming

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import spacecraftflipcards.composeapp.generated.resources.ChivoMono
import spacecraftflipcards.composeapp.generated.resources.Res

val chivoMono: FontFamily
    @Composable
    get() {
        return FontFamily(
            Font(resource = Res.font.ChivoMono, weight = FontWeight.Normal)
        )
    }