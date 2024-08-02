package com.gft.mobius.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.isUnspecified
import com.gft.mobius.colors.LocalContentColor

val LocalIconSize = compositionLocalOf<IconSize>(structuralEqualityPolicy()) { IconSize.Unspecified }

@Composable
fun ProvideIconSize(value: IconSize, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalIconSize provides value, content = content)
}

@Composable
fun Icon(
    @DrawableRes drawableResId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: IconSize = LocalIconSize.current,
    tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
    painter = painterResource(id = drawableResId),
    contentDescription = contentDescription,
    modifier = modifier.size(size),
    tint = tint
)

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: IconSize = LocalIconSize.current,
    tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
    imageVector = imageVector,
    contentDescription = contentDescription,
    modifier = modifier.size(size),
    tint = tint
)

@Composable
fun Icon(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: IconSize = LocalIconSize.current,
    tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
    bitmap = bitmap,
    contentDescription = contentDescription,
    modifier = modifier.size(size),
    tint = tint
)

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: IconSize = LocalIconSize.current,
    tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
    painter = painter,
    contentDescription = contentDescription,
    modifier = modifier.size(size),
    tint = tint
)

@Composable
private fun Modifier.size(value: IconSize) = this.then(
    if (value.size.isUnspecified) Modifier
    else requiredSize(value.size)
)