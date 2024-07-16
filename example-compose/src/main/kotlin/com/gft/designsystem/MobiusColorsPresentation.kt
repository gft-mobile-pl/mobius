package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius.colors

@Composable
fun MobiusColorsPresentation() {
    val colorsToDisplay = colorItems()
    LazyVerticalGrid(
        modifier = Modifier.padding(4.dp),
        columns = GridCells.Adaptive(minSize = 160.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(colorsToDisplay) { colorItem ->
            ColorView(colorItem)
        }
    }
}

@Composable
private fun colorItems() = listOf(
    ColorItem(colors.primary, colors.onPrimary, "Primary"),
    ColorItem(colors.onPrimary, colors.primary, "On Primary"),
    ColorItem(colors.secondary, colors.onSecondary, "Secondary"),
    ColorItem(colors.onSecondary, colors.secondary, "On Secondary"),
    ColorItem(colors.tertiary, colors.onTertiary, "Tertiary"),
    ColorItem(colors.onTertiary, colors.tertiary, "On Tertiary"),
    ColorItem(colors.inversePrimary, colors.onPrimary, "Inverse Primary"),
    ColorItem(Color.White, Color.White, "----------------------"),

    ColorItem(colors.primaryContainer, colors.onPrimaryContainer, "Primary Container"),
    ColorItem(colors.onPrimaryContainer, colors.primaryContainer, "On Primary Container"),
    ColorItem(colors.secondaryContainer, colors.onSecondaryContainer, "Secondary Container"),
    ColorItem(colors.onSecondaryContainer, colors.secondaryContainer, "On Secondary Container"),
    ColorItem(colors.tertiaryContainer, colors.onTertiaryContainer, "Tertiary Container"),
    ColorItem(colors.onTertiaryContainer, colors.tertiaryContainer, "On Tertiary Container"),

    ColorItem(colors.surface, colors.onSurface, "Surface"),
    ColorItem(colors.surfaceBright, colors.onSurface, "Surface Bright"),
    ColorItem(colors.surfaceDim, colors.onSurface, "Surface Dim"),
    ColorItem(colors.surfaceContainer, colors.onSurface, "Surface Container"),
    ColorItem(colors.surfaceContainerLow, colors.onSurface, "Surface Container Low"),
    ColorItem(colors.surfaceContainerLowest, colors.onSurface, "Surface Container Lowest"),
    ColorItem(colors.surfaceContainerHigh, colors.onSurface, "Surface Container High"),
    ColorItem(colors.surfaceContainerHighest, colors.onSurface, "Surface Container Highest"),
    ColorItem(colors.onSurface, colors.surface, "On Surface"),
    ColorItem(colors.onSurfaceVariant, colors.surface, "On Surface Variant"),

    ColorItem(colors.inverseSurface, colors.inverseOnSurface, "Inverse Surface"),
    ColorItem(colors.inverseOnSurface, colors.inverseSurface, "Inverse On Surface"),

    ColorItem(colors.outline, colors.outlineVariant, "Outline"),
    ColorItem(colors.outlineVariant, colors.outline, "Outline Variant"),

    ColorItem(colors.scrim, Color.White, "Scrim"),
    ColorItem(colors.shadow, Color.White, "Shadow"),

    ColorItem(colors.error, colors.onError, "Error"),
    ColorItem(colors.onError, colors.error, "On Error"),
    ColorItem(colors.errorContainer, colors.onErrorContainer, "Error Container"),
    ColorItem(colors.onErrorContainer, colors.errorContainer, "On Error Container"),
)

private data class ColorItem(
    val color: Color,
    val matchingColor: Color,
    val name: String
)

@Composable
private fun ColorView(
    colorItem: ColorItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(colorItem.color)
            .padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = colorItem.name,
            color = colorItem.matchingColor
        )
    }
}