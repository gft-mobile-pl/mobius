package com.gft.designsystem.whitelabel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyle

interface ButtonStyleValues : StyleValues {
    val content: Color
    val background: Color
}

interface ButtonStyle : Style {
    val content: Token<Color>
    val background: Token<Color>
}

@Composable
fun ButtonStyle.resolve(useCache: Boolean = true) = produceStyle(useCache) {
    object : ButtonStyleValues {
        override val content: Color = this@resolve.content.resolve()
        override val background: Color = this@resolve.background.resolve()
    }
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    style: ButtonStyleValues = WhiteLabelDesignSystem.styles.button.resolve(),
    content: @Composable ColumnScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalContentColor provides style.content
    ) {
        Column(
            modifier = modifier
                .background(style.background)
                .padding(16.dp)
                .clickable(onClick = onClick),
            content = content
        )
    }
}

@Composable
fun LighterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    // 👎 changes to ButtonStyle in local composition won't be reflected
    // Button(
    //     modifier = modifier,
    //     style = object : DefaultButtonStyle() {
    //         override val background: Token<Color> = Token(WhiteLabelDesignSystem.colors.color15)
    //     }.resolve(),
    //     onClick = onClick,
    //     content = content
    // )

    // 👎 new instance created on each recomposition causing button recomposition
    // Button(
    //     modifier = modifier,
    //     style = object : ButtonStyle by WhiteLabelDesignSystem.styles.button {
    //         override val background: Token<Color> = Token(WhiteLabelDesignSystem.colors.color15)
    //     }.resolve(),
    //     onClick = onClick,
    //     content = content
    // )

    // 👎 new instance created on each recomposition causing button recomposition
    // Button(
    //     modifier = modifier,
    //     style = object : ButtonStyle {
    //         override val content: Token<Color> = TokenReference { WhiteLabelDesignSystem.styles.button.content }
    //         override val background: Token<Color> = Token { WhiteLabelDesignSystem.colors.color15 }
    //     }.resolve(),
    //     onClick = onClick,
    //     content = content
    // )

    // 👌 but... 👎 requires adding button to style
    // Button(
    //     modifier = modifier,
    //     style = WhiteLabelDesignSystem.styles.lighterButton.resolve(),
    //     onClick = onClick,
    //     content = content
    // )

    // 👌 just perfect
    Button(
        modifier = modifier,
        style = rememberLighterButtonStyle().resolve(),
        onClick = onClick,
        content = content
    )
}

@Composable
fun rememberLighterButtonStyle(): ButtonStyle {
    val currentButtonStyle = WhiteLabelDesignSystem.styles.button
    return remember(currentButtonStyle) {
        return@remember object : ButtonStyle by currentButtonStyle {
            override val background: Token<Color> = Token { WhiteLabelDesignSystem.colors.color15 }
        }
    }
}
