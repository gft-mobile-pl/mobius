package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.common.copy
import com.gft.mobius.components.common.minus
import com.gft.mobius.components.common.union
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.PopUpScreenStyle
import com.gft.mobius.components.styles.PopUpScreenStyleValues
import com.gft.mobius.components.styles.resolve

@Composable
fun PopUpScreen(
    modifier: Modifier = Modifier,
    icon: (@Composable ColumnScope.() -> Unit)? = null,
    title: (@Composable ColumnScope.() -> Unit)? = null,
    buttons: (@Composable () -> Unit)? = null,
    isContentScrollable: Boolean = true,
    style: PopUpScreenStyle = Mobius.styles.popUpScreenStyle,
    content: (@Composable ColumnScope.() -> Unit)? = null,
) {
    val styleValues = style.resolve()
    DialogScreen(
        modifier = modifier
    ) {
        val headerVisible = title != null || icon != null
        val contentVisible = content != null
        val buttonsVisible = buttons != null

        if (headerVisible) {
            Header {
                PopUpHeader(
                    minimumPadding = styleValues.minimumPadding.copy(
                        bottom = if (contentVisible || buttonsVisible) 0.dp else Dp.Unspecified
                    ),
                    popUpStyleValues = styleValues,
                    icon = icon,
                    title = title,
                )
            }
        }
        if (contentVisible) {
            PopUpContent(
                isScrollable = isContentScrollable,
                minimumPadding = styleValues.minimumPadding.copy(
                    top = if (headerVisible) 0.dp else Dp.Unspecified,
                    bottom = if (buttonsVisible) 0.dp else Dp.Unspecified
                ),
                popUpStyleValues = styleValues,
                content = content!!,
            )
        }
        if (buttonsVisible) {
            Footer {
                PopUpButtons(
                    minimumPadding = styleValues.minimumPadding.copy(
                        top = if (headerVisible || contentVisible) 0.dp else Dp.Unspecified,
                    ),
                    popUpStyleValues = styleValues,
                    buttons = buttons!!
                )
            }
        }
    }
}

@Composable
private fun DialogScreenHeaderScope.PopUpHeader(
    minimumPadding: PaddingValues,
    popUpStyleValues: PopUpScreenStyleValues,
    icon: (@Composable ColumnScope.() -> Unit)? = null,
    title: (@Composable ColumnScope.() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillHeaderWidth()
            .modifyIf(popUpStyleValues.headerBackground != null) {
                background(popUpStyleValues.headerBackground!!)
            }
            .padding(
                popUpStyleValues.headerPadding.union(minimumPadding)
            ),
        horizontalAlignment = if (icon != null) popUpStyleValues.withIconHeaderAlignment else popUpStyleValues.textOnlyHeaderAlignment,
        verticalArrangement = popUpStyleValues.headerVerticalArrangement
    ) {
        if (icon != null) {
            CompositionLocalProvider(
                LocalIconSize provides popUpStyleValues.headerIconSize,
                LocalContentColor provides popUpStyleValues.headerIconContentColor
            ) {
                icon()
            }
        }
        if (title != null) {
            CompositionLocalProvider(
                LocalTextStyle provides popUpStyleValues.headerTextStyle,
                LocalContentColor provides popUpStyleValues.headerContentColor
            ) {
                title()
            }
        }
    }
}

@Composable
private fun DialogScreenScope.PopUpContent(
    isScrollable: Boolean = true,
    minimumPadding: PaddingValues,
    popUpStyleValues: PopUpScreenStyleValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    val contentStyleValues = popUpStyleValues.contentStyle.resolve()
    val additionalPadding = minimumPadding.minus(contentStyleValues.padding)
    val layoutDirection = LocalLayoutDirection.current

    additionalPadding.calculateTopPadding().let { padding ->
        if (padding > 0.dp) Spacer(modifier = Modifier.height(padding))
    }
    CompositionLocalProvider(LocalTextStyle provides popUpStyleValues.contentTextStyle) {
        Content(
            modifier = Modifier.padding(
                start = additionalPadding.calculateStartPadding(layoutDirection),
                end = additionalPadding.calculateEndPadding(layoutDirection)
            ),
            isScrollable = isScrollable,
            style = popUpStyleValues.contentStyle,
            content = content
        )
    }
    additionalPadding.calculateBottomPadding().let { padding ->
        if (padding > 0.dp) Spacer(modifier = Modifier.height(padding))
    }
}

@Composable
private fun DialogScreenFooterScope.PopUpButtons(
    minimumPadding: PaddingValues,
    popUpStyleValues: PopUpScreenStyleValues,
    buttons: @Composable () -> Unit,
) {
    val dialogButtonsStyleValues = popUpStyleValues.buttonsStyle.resolve()
    DialogButtons(
        modifier = Modifier.padding(minimumPadding.minus(other = dialogButtonsStyleValues.padding)),
        style = popUpStyleValues.buttonsStyle,
        buttons = buttons
    )
}
