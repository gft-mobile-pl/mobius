package com.gft.mobius.components

import android.os.Build
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogWindowProvider
import androidx.lifecycle.Lifecycle
import com.gft.compose.common.modifyIf
import com.gft.compose.interaction.InteractionFilter
import com.gft.compose.interaction.clearFocusOnClick
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.styles.DialogScreenStyle
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.references.MobiusReferenceDimensions

@Composable
fun DialogScreen(
    modifier: Modifier = Modifier,
    minActiveState: Lifecycle.State = Lifecycle.State.RESUMED,
    clearFocusOnClick: Boolean = true,
    style: DialogScreenStyle = Mobius.styles.dialogScreenStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

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

    InteractionFilter(
        minActiveState = minActiveState
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor
        ) {
            Column(
                modifier = Modifier
                    .modifyIf(clearFocusOnClick) { clearFocusOnClick() }
                    .modifyIf(styleValues.shape != null) {
                        clip(styleValues.shape!!)
                    }
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .padding(styleValues.paddingValues)
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .then(modifier),
                content = content
            )
        }
    }
}