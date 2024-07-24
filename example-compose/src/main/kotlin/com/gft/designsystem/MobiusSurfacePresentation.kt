package com.gft.designsystem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Surface
import com.gft.mobius.components.Text

@Composable
fun MobiusSurfacePresentation() {
    Mobius {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val content = @Composable { Text("Sample text") }
            val modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)

            Surface(
                modifier = modifier,
                content = content
            )
            Surface(
                modifier = modifier,
                color = Mobius.colors.primary,
                content = content
            )
            Surface(
                modifier = modifier,
                color = Mobius.colors.primary,
                contentColor = Mobius.colors.error,
                content = content
            )
            Surface(
                modifier = modifier,
                tonalElevation = 16.dp,
                content = content
            )
            Surface(
                modifier = modifier,
                shadowElevation = 6.dp,
                content = content
            )
            Surface(
                modifier = modifier,
                shadowElevation = 6.dp,
                border = BorderStroke(4.dp, Brush.verticalGradient(listOf(Mobius.colors.primary, Mobius.colors.error))),
                content = content
            )
        }
    }
}