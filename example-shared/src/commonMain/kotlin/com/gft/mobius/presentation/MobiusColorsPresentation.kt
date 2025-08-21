package com.gft.mobius.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.colors.MobiusDarkColors
import com.gft.mobius.colors.MobiusLightColors
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Text

enum class MobiusColorsMode {
    Light,
    Dark
}

@Composable
fun MobiusColorsPresentation(
    colorsMode: MobiusColorsMode,
    onBack: () -> Unit,
) {
    Mobius(
        colors = if (colorsMode == MobiusColorsMode.Light) MobiusLightColors() else MobiusDarkColors()
    ) {
        Column {
            MobiusPresentationNavigationBar(
                title = if (colorsMode == MobiusColorsMode.Light) "Light colors" else "Dark colors",
                onBack = onBack
            )
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
    }
}

@Composable
private fun colorItems() = listOf(
    ColorItem(Mobius.colors.primary, Mobius.colors.onPrimary, "Primary"),
    ColorItem(Mobius.colors.onPrimary, Mobius.colors.primary, "On Primary"),
    ColorItem(Mobius.colors.secondary, Mobius.colors.onSecondary, "Secondary"),
    ColorItem(Mobius.colors.onSecondary, Mobius.colors.secondary, "On Secondary"),
    ColorItem(Mobius.colors.tertiary, Mobius.colors.onTertiary, "Tertiary"),
    ColorItem(Mobius.colors.onTertiary, Mobius.colors.tertiary, "On Tertiary"),
    ColorItem(Mobius.colors.inversePrimary, Mobius.colors.onPrimary, "Inverse Primary"),
    ColorItem(Color.White, Color.White, "----------------------"),

    ColorItem(Mobius.colors.primaryContainer, Mobius.colors.onPrimaryContainer, "Primary Container"),
    ColorItem(Mobius.colors.onPrimaryContainer, Mobius.colors.primaryContainer, "On Primary Container"),
    ColorItem(Mobius.colors.secondaryContainer, Mobius.colors.onSecondaryContainer, "Secondary Container"),
    ColorItem(Mobius.colors.onSecondaryContainer, Mobius.colors.secondaryContainer, "On Secondary Container"),
    ColorItem(Mobius.colors.tertiaryContainer, Mobius.colors.onTertiaryContainer, "Tertiary Container"),
    ColorItem(Mobius.colors.onTertiaryContainer, Mobius.colors.tertiaryContainer, "On Tertiary Container"),

    ColorItem(Mobius.colors.surface, Mobius.colors.onSurface, "Surface"),
    ColorItem(Mobius.colors.surfaceBright, Mobius.colors.onSurface, "Surface Bright"),
    ColorItem(Mobius.colors.surfaceDim, Mobius.colors.onSurface, "Surface Dim"),
    ColorItem(Mobius.colors.surfaceContainer, Mobius.colors.onSurface, "Surface Container"),
    ColorItem(Mobius.colors.surfaceContainerLow, Mobius.colors.onSurface, "Surface Container Low"),
    ColorItem(Mobius.colors.surfaceContainerLowest, Mobius.colors.onSurface, "Surface Container Lowest"),
    ColorItem(Mobius.colors.surfaceContainerHigh, Mobius.colors.onSurface, "Surface Container High"),
    ColorItem(Mobius.colors.surfaceContainerHighest, Mobius.colors.onSurface, "Surface Container Highest"),
    ColorItem(Mobius.colors.onSurface, Mobius.colors.surface, "On Surface"),
    ColorItem(Mobius.colors.onSurfaceVariant, Mobius.colors.surface, "On Surface Variant"),

    ColorItem(Mobius.colors.inverseSurface, Mobius.colors.inverseOnSurface, "Inverse Surface"),
    ColorItem(Mobius.colors.inverseOnSurface, Mobius.colors.inverseSurface, "Inverse On Surface"),

    ColorItem(Mobius.colors.outline, Mobius.colors.outlineVariant, "Outline"),
    ColorItem(Mobius.colors.outlineVariant, Mobius.colors.outline, "Outline Variant"),

    ColorItem(Mobius.colors.scrim, Color.White, "Scrim"),
    ColorItem(Mobius.colors.shadow, Color.White, "Shadow"),

    ColorItem(Mobius.colors.error, Mobius.colors.onError, "Error"),
    ColorItem(Mobius.colors.onError, Mobius.colors.error, "On Error"),
    ColorItem(Mobius.colors.errorContainer, Mobius.colors.onErrorContainer, "Error Container"),
    ColorItem(Mobius.colors.onErrorContainer, Mobius.colors.errorContainer, "On Error Container"),
)

private data class ColorItem(
    val color: Color,
    val matchingColor: Color,
    val name: String,
)

@Composable
private fun ColorView(
    colorItem: ColorItem,
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
