package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface ContentStyleValues : StyleValues {
    val padding: PaddingValues
    val background: Brush?
    val contentColor: Color
    val verticalArrangement: Arrangement.Vertical
    val horizontalAlignment: Alignment.Horizontal
}

interface ContentStyle : Style {
    val padding: Token<PaddingValues>
    val background: Token<Brush?>
    val contentColor: Token<Color>
    val verticalArrangement: Token<Arrangement.Vertical>
    val horizontalAlignment: Token<Alignment.Horizontal>
}

@Composable
fun ContentStyle.resolve() = produceStyleValues { style ->
    object : ContentStyleValues {
        override val padding = style.padding.resolve()
        override val background = style.background.resolve()
        override val contentColor = style.contentColor.resolve()
        override val verticalArrangement = style.verticalArrangement.resolve()
        override val horizontalAlignment = style.horizontalAlignment.resolve()
    }
}

open class DefaultContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension16,
            end = MobiusReferenceDimensions.Dimension16,
            top = MobiusReferenceDimensions.Dimension16,
            bottom = MobiusReferenceDimensions.Dimension16,
        )
    )
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.background) }
    override val contentColor: Token<Color> = Token { Mobius.colors.onBackground }
    override val verticalArrangement: Token<Arrangement.Vertical> = Token(Arrangement.Top)
    override val horizontalAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
}

open class DefaultDialogContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(all = MobiusReferenceDimensions.Dimension24)
    )
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.surfaceContainerHigh) }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val verticalArrangement: Token<Arrangement.Vertical> = Token(Arrangement.Top)
    override val horizontalAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
}

open class DefaultHeaderContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.contentStyle.padding }
    override val background: Token<Brush?> = Token(null)
    override val contentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val verticalArrangement: Token<Arrangement.Vertical> = Token(Arrangement.Center)
    override val horizontalAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
}

open class DefaultDialogHeaderContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.dialogContentStyle.padding }
    override val background: Token<Brush?> = Token(null)
    override val contentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val verticalArrangement: Token<Arrangement.Vertical> = Token(Arrangement.Center)
    override val horizontalAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
}