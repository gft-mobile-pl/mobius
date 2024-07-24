package com.gft.mobius.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun Icon(
    @DrawableRes drawableResId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) = androidx.compose.material3.Icon(
    painter = painterResource(id = drawableResId),
    contentDescription = contentDescription,
    modifier = modifier,
    tint = tint
)

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) = androidx.compose.material3.Icon(
    imageVector = imageVector,
    contentDescription = contentDescription,
    modifier = modifier,
    tint = tint
)

@Composable
fun Icon(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) = androidx.compose.material3.Icon(
    bitmap = bitmap,
    contentDescription = contentDescription,
    modifier = modifier,
    tint = tint
)

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) = androidx.compose.material3.Icon(
    painter = painter,
    contentDescription = contentDescription,
    modifier = modifier,
    tint = tint
)