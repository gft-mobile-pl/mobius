@file:JvmName("IconAndroid")
package com.gft.mobius.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.gft.mobius.colors.LocalContentColor

@Composable
fun Icon(
    @DrawableRes drawableResId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: IconSize = LocalIconSize.current,
    tint: Color = LocalContentColor.current,
) = androidx.compose.material3.Icon(
    painter = painterResource(drawableResId),
    contentDescription = contentDescription,
    modifier = modifier.size(size),
    tint = tint
)
