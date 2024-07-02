package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.designsystem.whitelabel.Button
import com.gft.designsystem.whitelabel.ButtonStyle
import com.gft.designsystem.whitelabel.ButtonStyleValues
import com.gft.designsystem.whitelabel.WhiteLabelStyles

interface AppStyles : WhiteLabelStyles {
    val borderedButtonStyle: BorderedButtonStyle
}


interface BorderedButtonStyleValues : ButtonStyleValues {
    val border: Color
}

interface BorderedButtonStyle : ButtonStyle {
    val border: Token<Color>
}

@Composable
fun BorderedButtonStyle.resolve(): BorderedButtonStyleValues = produceStyle {
    object : BorderedButtonStyleValues {
        override val border: Color = this@resolve.border.resolve()
        override val content: Color = this@resolve.content.resolve()
        override val background: Color = this@resolve.background.resolve()
    }
}

@Composable
fun BorderedButton(
    onClick: () -> Unit,
    style: BorderedButtonStyleValues = AppDesignSystem.styles.borderedButtonStyle.resolve(),
    content: @Composable ColumnScope.() -> Unit,
) {
    Button(
        modifier = Modifier.background(style.border).padding(16.dp),
        style = style,
        onClick = onClick,
        content = content
    )
}

