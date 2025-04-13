package me.androidbox.spacecraftflipcards

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import org.jetbrains.compose.resources.vectorResource
import spacecraftflipcards.composeapp.generated.resources.Res
import spacecraftflipcards.composeapp.generated.resources.back
import spacecraftflipcards.composeapp.generated.resources.front

@Composable
fun App() {
    MaterialTheme {
        var rotated by remember {
            mutableStateOf(false)
        }

        val rotation by animateFloatAsState(
            targetValue = if(rotated) 180f else 0f,
            animationSpec = tween(500)
        )

        val animateFront by animateFloatAsState(
            targetValue = if(!rotated) 1F else 0f,
            animationSpec = tween(500)
        )

        val animateBack by animateFloatAsState(
            targetValue = if(rotated) 1F else 0f,
            animationSpec = tween(500)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xff210A41))
                .graphicsLayer {
                    this.rotationY = rotation
                    this.cameraDistance = 8 * density
                }
                .clickable {
                    rotated = !rotated
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .graphicsLayer {
                        this.alpha = animateFront
                        this.alpha = if(rotation < 90f) animateFront else 0f
                    },
                imageVector = vectorResource(Res.drawable.front),
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .graphicsLayer {
                        this.alpha = animateBack
                        this.alpha = if(rotation >= 90F) animateBack else 0f
                        this.rotationY = 180F
                    },
                imageVector = vectorResource(Res.drawable.back),
                contentDescription = null
            )
        }
    }
}
