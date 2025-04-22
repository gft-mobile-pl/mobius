package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues

@GenerateStyleValues
interface FooterStyle : Style {
    val background: Token<Brush?>
    val contentColor: Token<Color>
}

open class DefaultFooterStyle : FooterStyle {
    override val background: Token<Brush?> = Token(null)
    override val contentColor: Token<Color> = Token(Color.Unspecified)
}
