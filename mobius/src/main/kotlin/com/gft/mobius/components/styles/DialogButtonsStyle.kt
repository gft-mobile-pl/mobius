package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.DialogButtonsStyle.ButtonsLayout
import com.gft.mobius.references.MobiusReferenceDimensions

interface DialogButtonsStyleValues : StyleValues {
    val padding: PaddingValues
    val background: Brush?
    val buttonsLayout: ButtonsLayout
}

interface DialogButtonsStyle : Style {
    val padding: Token<PaddingValues>
    val background: Token<Brush?>
    val buttonsLayout: Token<ButtonsLayout>

    @Stable
    sealed interface ButtonsLayout {
        data class Column(
            val horizontalAlignment: Alignment.Horizontal = Alignment.End,
            val verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(MobiusReferenceDimensions.Dimension8),
            val buttonWidth: ButtonWidth = ButtonWidth.Max,
        ) : ButtonsLayout

        data class HorizontalFlow(
            val horizontalAlignment: Alignment.Horizontal = Alignment.End,
            val horizontalSpacing: Dp = MobiusReferenceDimensions.Dimension8,
            val verticalSpacing: Dp = MobiusReferenceDimensions.Dimension12,
            val reverseButtonsOrder: Boolean = true,
        ) : ButtonsLayout

        sealed interface ButtonWidth {
            data class Fixed(val width: Dp) : ButtonWidth
            data object Default : ButtonWidth
            data object Max : ButtonWidth
            data object MatchOtherButtons : ButtonWidth
        }
    }
}

@Composable
fun DialogButtonsStyle.resolve() = produceStyleValues { style ->
    object : DialogButtonsStyleValues {
        override val padding: PaddingValues = style.padding.resolve()
        override val background: Brush? = style.background.resolve()
        override val buttonsLayout: ButtonsLayout = style.buttonsLayout.resolve()
    }
}

open class DefaultDialogButtonsStyle : DialogButtonsStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.dialogContentStyle.padding }
    override val background: Token<Brush?> = Token(null)
    override val buttonsLayout: Token<ButtonsLayout> = Token(ButtonsLayout.HorizontalFlow())
}
