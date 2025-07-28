package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.PopUpScreen.ScrollPolicy
import com.gft.mobius.components.common.copy
import com.gft.mobius.components.common.minus
import com.gft.mobius.components.common.union
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.PopUpScreenStyle
import com.gft.mobius.components.styles.PopUpScreenStyleValues
import com.gft.mobius.components.styles.resolve

object PopUpScreen {
    enum class ScrollPolicy {
        NoScroll,
        ScrollContentOnly,
        ScrollEverything
    }
}

@Composable
fun PopUpScreen(
    modifier: Modifier = Modifier,
    icon: (@Composable ColumnScope.() -> Unit)? = null,
    title: (@Composable ColumnScope.() -> Unit)? = null,
    buttons: (@Composable () -> Unit)? = null,
    scrollPolicy: ScrollPolicy = ScrollPolicy.ScrollContentOnly,
    style: PopUpScreenStyle = Mobius.styles.popUpScreenStyle,
    content: (@Composable DialogScreenContentScope.() -> Unit)? = null,
) {
    val styleValues = style.resolve()
    DialogScreen(
        modifier = modifier,
        style = style
    ) {
        val headerVisible = title != null || icon != null
        val contentVisible = content != null
        val buttonsVisible = buttons != null

        PopUpScreenLayout(
            header = if (headerVisible) {
                {
                    PopUpHeader(
                        minimumPadding = styleValues.minimumPadding.copy(
                            bottom = if (contentVisible || buttonsVisible) 0.dp else Dp.Unspecified
                        ),
                        popUpStyleValues = styleValues,
                        icon = icon,
                        title = title,
                    )
                }
            } else null,
            contentWrapper = if (contentVisible || scrollPolicy != ScrollPolicy.ScrollContentOnly) {
                { contentToWrap ->
                    PopUpContent(
                        isScrollable = scrollPolicy != ScrollPolicy.NoScroll,
                        minimumPadding = styleValues.minimumPadding.copy(
                            top = if (headerVisible) 0.dp else Dp.Unspecified,
                            bottom = if (buttonsVisible) 0.dp else Dp.Unspecified
                        ),
                        popUpStyleValues = styleValues,
                        content = contentToWrap,
                    )
                }
            } else null,
            content = content,
            footer = if (buttonsVisible) {
                {
                    PopUpButtons(
                        minimumPadding = styleValues.minimumPadding.copy(
                            top = if (headerVisible || contentVisible) 0.dp else Dp.Unspecified,
                        ),
                        popUpStyleValues = styleValues,
                        buttons = buttons!!
                    )
                }
            } else null,
            scrollPolicy = scrollPolicy,
        )
    }
}

@Composable
private fun DialogScreenScope.PopUpScreenLayout(
    header: (@Composable DialogScreenHeaderScope.() -> Unit)?,
    contentWrapper: (@Composable DialogScreenScope.(@Composable DialogScreenContentScope.() -> Unit) -> Unit)?,
    content: (@Composable DialogScreenContentScope.() -> Unit)? = null,
    footer: (@Composable DialogScreenFooterScope.() -> Unit)?,
    scrollPolicy: ScrollPolicy = ScrollPolicy.ScrollContentOnly,
) {
    when (scrollPolicy) {
        ScrollPolicy.NoScroll, ScrollPolicy.ScrollEverything -> {
            if (contentWrapper != null) {
                contentWrapper {
                    if (header != null) Header { header() }
                    if (content != null) content()
                    if (footer != null) Footer { footer() }
                }
            }
        }

        ScrollPolicy.ScrollContentOnly -> {
            if (header != null) Header { header() }
            if (contentWrapper != null) contentWrapper(content!!)
            if (footer != null) Footer { footer() }
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
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    val contentStyleValues = popUpStyleValues.contentStyle.resolve()
    val updateContentStyleValues: ContentStyleValues = object : ContentStyleValues by contentStyleValues {
        override val padding: PaddingValues = contentStyleValues.padding.union(minimumPadding)
    }
    CompositionLocalProvider(LocalTextStyle provides popUpStyleValues.contentTextStyle) {
        Content(
            scrollState = if (isScrollable) rememberScrollState() else null,
            styleValues = updateContentStyleValues,
            content = content
        )
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
