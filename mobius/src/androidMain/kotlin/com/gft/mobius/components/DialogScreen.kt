@file:JvmName("DialogScreenAndroid")

package com.gft.mobius.components

import android.os.Build
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogWindowProvider
import com.gft.mobius.components.styles.DialogScreenStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

@Composable
internal actual fun applyBlurUnderDialogScreen(styleValues: DialogScreenStyleValues) {
    if (styleValues.underlyingContentBlur != Dp.Unspecified
        && styleValues.underlyingContentBlur != MobiusReferenceDimensions.Dimension0
        && Build.VERSION.SDK_INT > Build.VERSION_CODES.R
    ) {
        val blur = with(LocalDensity.current) { styleValues.underlyingContentBlur.roundToPx() }
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        LaunchedEffect(Unit) {
            dialogWindowProvider.window.apply {
                setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                attributes.blurBehindRadius = blur
            }
        }
    }
}
