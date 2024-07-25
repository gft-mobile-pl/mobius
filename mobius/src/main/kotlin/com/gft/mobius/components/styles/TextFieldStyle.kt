package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface TextFieldStyleValues : StyleValues {
    val textStyle: TextStyle
    val labelsTextStyle: TextStyle
    val shape: Shape
    val selectionHandleColor: Color
    val selectionBackgroundColor: Color
    val focusedTextColor: Color
    val unfocusedTextColor: Color
    val disabledTextColor: Color
    val errorTextColor: Color
    val focusedContainerColor: Color
    val unfocusedContainerColor: Color
    val disabledContainerColor: Color
    val errorContainerColor: Color
    val cursorColor: Color
    val errorCursorColor: Color
    val focusedIndicatorColor: Color
    val unfocusedIndicatorColor: Color
    val disabledIndicatorColor: Color
    val errorIndicatorColor: Color
    val focusedLeadingIconColor: Color
    val unfocusedLeadingIconColor: Color
    val disabledLeadingIconColor: Color
    val errorLeadingIconColor: Color
    val focusedTrailingIconColor: Color
    val unfocusedTrailingIconColor: Color
    val disabledTrailingIconColor: Color
    val errorTrailingIconColor: Color
    val focusedLabelColor: Color
    val unfocusedLabelColor: Color
    val disabledLabelColor: Color
    val errorLabelColor: Color
    val focusedPlaceholderColor: Color
    val unfocusedPlaceholderColor: Color
    val disabledPlaceholderColor: Color
    val errorPlaceholderColor: Color
    val focusedSupportingTextColor: Color
    val unfocusedSupportingTextColor: Color
    val disabledSupportingTextColor: Color
    val errorSupportingTextColor: Color
    val focusedPrefixColor: Color
    val unfocusedPrefixColor: Color
    val disabledPrefixColor: Color
    val errorPrefixColor: Color
    val focusedSuffixColor: Color
    val unfocusedSuffixColor: Color
    val disabledSuffixColor: Color
    val errorSuffixColor: Color
}

interface TextFieldStyle : Style {
    val textStyle: Token<TextStyle>
    val labelsTextStyle: Token<TextStyle>
    val focusedTextColor: Token<Color>
    val unfocusedTextColor: Token<Color>
    val disabledTextColor: Token<Color>
    val errorTextColor: Token<Color>
    val focusedContainerColor: Token<Color>
    val unfocusedContainerColor: Token<Color>
    val disabledContainerColor: Token<Color>
    val errorContainerColor: Token<Color>
    val cursorColor: Token<Color>
    val errorCursorColor: Token<Color>
    val focusedIndicatorColor: Token<Color>
    val unfocusedIndicatorColor: Token<Color>
    val disabledIndicatorColor: Token<Color>
    val errorIndicatorColor: Token<Color>
    val focusedLeadingIconColor: Token<Color>
    val unfocusedLeadingIconColor: Token<Color>
    val disabledLeadingIconColor: Token<Color>
    val errorLeadingIconColor: Token<Color>
    val focusedTrailingIconColor: Token<Color>
    val unfocusedTrailingIconColor: Token<Color>
    val disabledTrailingIconColor: Token<Color>
    val errorTrailingIconColor: Token<Color>
    val focusedLabelColor: Token<Color>
    val unfocusedLabelColor: Token<Color>
    val disabledLabelColor: Token<Color>
    val errorLabelColor: Token<Color>
    val focusedPlaceholderColor: Token<Color>
    val unfocusedPlaceholderColor: Token<Color>
    val disabledPlaceholderColor: Token<Color>
    val errorPlaceholderColor: Token<Color>
    val focusedSupportingTextColor: Token<Color>
    val unfocusedSupportingTextColor: Token<Color>
    val disabledSupportingTextColor: Token<Color>
    val errorSupportingTextColor: Token<Color>
    val focusedPrefixColor: Token<Color>
    val unfocusedPrefixColor: Token<Color>
    val disabledPrefixColor: Token<Color>
    val errorPrefixColor: Token<Color>
    val focusedSuffixColor: Token<Color>
    val unfocusedSuffixColor: Token<Color>
    val disabledSuffixColor: Token<Color>
    val errorSuffixColor: Token<Color>
    val shape: Token<Shape>
    val selectionHandleColor: Token<Color>
    val selectionBackgroundColor: Token<Color>
    val selectionBackgroundOpacity: Token<Float>
}

@Composable
fun TextFieldStyle.resolve() = produceStyleValues { style ->
    object : TextFieldStyleValues {
        override val textStyle = style.textStyle.resolve()
        override val labelsTextStyle = style.labelsTextStyle.resolve()
        override val shape = style.shape.resolve()
        override val selectionHandleColor = style.selectionHandleColor.resolve()
        override val selectionBackgroundColor = style.selectionBackgroundColor.resolve()
            .copy(alpha = style.selectionBackgroundOpacity.resolve())
        override val focusedTextColor = style.focusedTextColor.resolve()
        override val unfocusedTextColor = style.unfocusedTextColor.resolve()
        override val disabledTextColor = style.disabledTextColor.resolve()
        override val errorTextColor = style.errorTextColor.resolve()
        override val focusedContainerColor = style.focusedContainerColor.resolve()
        override val unfocusedContainerColor = style.unfocusedContainerColor.resolve()
        override val disabledContainerColor = style.disabledContainerColor.resolve()
        override val errorContainerColor = style.errorContainerColor.resolve()
        override val cursorColor = style.cursorColor.resolve()
        override val errorCursorColor = style.errorCursorColor.resolve()
        override val focusedIndicatorColor = style.focusedIndicatorColor.resolve()
        override val unfocusedIndicatorColor = style.unfocusedIndicatorColor.resolve()
        override val disabledIndicatorColor = style.disabledIndicatorColor.resolve()
        override val errorIndicatorColor = style.errorIndicatorColor.resolve()
        override val focusedLeadingIconColor = style.focusedLeadingIconColor.resolve()
        override val unfocusedLeadingIconColor = style.unfocusedLeadingIconColor.resolve()
        override val disabledLeadingIconColor = style.disabledLeadingIconColor.resolve()
        override val errorLeadingIconColor = style.errorLeadingIconColor.resolve()
        override val focusedTrailingIconColor = style.focusedTrailingIconColor.resolve()
        override val unfocusedTrailingIconColor = style.unfocusedTrailingIconColor.resolve()
        override val disabledTrailingIconColor = style.disabledTrailingIconColor.resolve()
        override val errorTrailingIconColor = style.errorTrailingIconColor.resolve()
        override val focusedLabelColor = style.focusedLabelColor.resolve()
        override val unfocusedLabelColor = style.unfocusedLabelColor.resolve()
        override val disabledLabelColor = style.disabledLabelColor.resolve()
        override val errorLabelColor = style.errorLabelColor.resolve()
        override val focusedPlaceholderColor = style.focusedPlaceholderColor.resolve()
        override val unfocusedPlaceholderColor = style.unfocusedPlaceholderColor.resolve()
        override val disabledPlaceholderColor = style.disabledPlaceholderColor.resolve()
        override val errorPlaceholderColor = style.errorPlaceholderColor.resolve()
        override val focusedSupportingTextColor = style.focusedSupportingTextColor.resolve()
        override val unfocusedSupportingTextColor = style.unfocusedSupportingTextColor.resolve()
        override val disabledSupportingTextColor = style.disabledSupportingTextColor.resolve()
        override val errorSupportingTextColor = style.errorSupportingTextColor.resolve()
        override val focusedPrefixColor = style.focusedPrefixColor.resolve()
        override val unfocusedPrefixColor = style.unfocusedPrefixColor.resolve()
        override val disabledPrefixColor = style.disabledPrefixColor.resolve()
        override val errorPrefixColor = style.errorPrefixColor.resolve()
        override val focusedSuffixColor = style.focusedSuffixColor.resolve()
        override val unfocusedSuffixColor = style.unfocusedSuffixColor.resolve()
        override val disabledSuffixColor = style.disabledSuffixColor.resolve()
        override val errorSuffixColor = style.errorSuffixColor.resolve()
    }
}

open class DefaultTextFieldStyle : TextFieldStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.text }
    override val labelsTextStyle: Token<TextStyle> = Token { Mobius.typography.bodySmall }
    override val focusedTextColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val unfocusedTextColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledTextColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorTextColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val focusedContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val unfocusedContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val disabledContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val errorContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val cursorColor: Token<Color> = Token { Mobius.colors.primary }
    override val errorCursorColor: Token<Color> = Token { Mobius.colors.error }
    override val focusedIndicatorColor: Token<Color> = Token { Mobius.colors.primary }
    override val unfocusedIndicatorColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledIndicatorColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorIndicatorColor: Token<Color> = Token { Mobius.colors.error }
    override val focusedLeadingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedLeadingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledLeadingIconColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) } // CHECK ALPHA
    override val errorLeadingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val focusedTrailingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedTrailingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledTrailingIconColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorTrailingIconColor: Token<Color> = Token { Mobius.colors.error }
    override val focusedLabelColor: Token<Color> = Token { Mobius.colors.primary }
    override val unfocusedLabelColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledLabelColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorLabelColor: Token<Color> = Token { Mobius.colors.error }
    override val focusedPlaceholderColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedPlaceholderColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledPlaceholderColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorPlaceholderColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val focusedSupportingTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedSupportingTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledSupportingTextColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorSupportingTextColor: Token<Color> = Token { Mobius.colors.error }
    override val focusedPrefixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedPrefixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledPrefixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val errorPrefixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val focusedSuffixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unfocusedSuffixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledSuffixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val errorSuffixColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val shape: Token<Shape> = Token(
        RoundedCornerShape(
            topStart = 4.0.dp,
            topEnd = 4.0.dp,
            bottomEnd = 0.0.dp,
            bottomStart = 0.0.dp
        )
    )
    override val selectionHandleColor: Token<Color> = Token { Mobius.colors.primary }
    override val selectionBackgroundColor: Token<Color> = Token { Mobius.colors.primary }
    override val selectionBackgroundOpacity: Token<Float> = Token(0.4f)
}

open class DefaultOutlinedTextFieldStyle : TextFieldStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.textField.textStyle }
    override val labelsTextStyle: Token<TextStyle> = TokenReference { Mobius.styles.textField.labelsTextStyle }
    override val focusedTextColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedTextColor }
    override val unfocusedTextColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedTextColor }
    override val disabledTextColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledTextColor }
    override val errorTextColor: Token<Color> = TokenReference { Mobius.styles.textField.errorTextColor }
    override val focusedContainerColor: Token<Color> = Token(Color.Transparent)
    override val unfocusedContainerColor: Token<Color> = Token(Color.Transparent)
    override val disabledContainerColor: Token<Color> = Token(Color.Transparent)
    override val errorContainerColor: Token<Color> = Token(Color.Transparent)
    override val cursorColor: Token<Color> = TokenReference { Mobius.styles.textField.cursorColor }
    override val errorCursorColor: Token<Color> = TokenReference { Mobius.styles.textField.errorCursorColor }
    override val focusedIndicatorColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedIndicatorColor }
    override val unfocusedIndicatorColor: Token<Color> = Token { Mobius.colors.outline } //
    override val disabledIndicatorColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) } //
    override val errorIndicatorColor: Token<Color> = TokenReference { Mobius.styles.textField.errorIndicatorColor }
    override val focusedLeadingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedLeadingIconColor }
    override val unfocusedLeadingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedLeadingIconColor }
    override val disabledLeadingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledLeadingIconColor }
    override val errorLeadingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.errorLeadingIconColor }
    override val focusedTrailingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedTrailingIconColor }
    override val unfocusedTrailingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedTrailingIconColor }
    override val disabledTrailingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledTrailingIconColor }
    override val errorTrailingIconColor: Token<Color> = TokenReference { Mobius.styles.textField.errorTrailingIconColor }
    override val focusedLabelColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedLabelColor }
    override val unfocusedLabelColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedLabelColor }
    override val disabledLabelColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledLabelColor }
    override val errorLabelColor: Token<Color> = TokenReference { Mobius.styles.textField.errorLabelColor }
    override val focusedPlaceholderColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedPlaceholderColor }
    override val unfocusedPlaceholderColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedPlaceholderColor }
    override val disabledPlaceholderColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledPlaceholderColor }
    override val errorPlaceholderColor: Token<Color> = TokenReference { Mobius.styles.textField.errorPlaceholderColor }
    override val focusedSupportingTextColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedSupportingTextColor }
    override val unfocusedSupportingTextColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedSupportingTextColor }
    override val disabledSupportingTextColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledSupportingTextColor }
    override val errorSupportingTextColor: Token<Color> = TokenReference { Mobius.styles.textField.errorSupportingTextColor }
    override val focusedPrefixColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedPrefixColor }
    override val unfocusedPrefixColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedPrefixColor }
    override val disabledPrefixColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledPrefixColor }
    override val errorPrefixColor: Token<Color> = TokenReference { Mobius.styles.textField.errorPrefixColor }
    override val focusedSuffixColor: Token<Color> = TokenReference { Mobius.styles.textField.focusedSuffixColor }
    override val unfocusedSuffixColor: Token<Color> = TokenReference { Mobius.styles.textField.unfocusedSuffixColor }
    override val disabledSuffixColor: Token<Color> = TokenReference { Mobius.styles.textField.disabledSuffixColor }
    override val errorSuffixColor: Token<Color> = TokenReference { Mobius.styles.textField.errorSuffixColor }
    override val shape: Token<Shape> = Token(RoundedCornerShape(4.0.dp))
    override val selectionHandleColor: Token<Color> = TokenReference { Mobius.styles.textField.selectionHandleColor }
    override val selectionBackgroundColor: Token<Color> = TokenReference { Mobius.styles.textField.selectionBackgroundColor }
    override val selectionBackgroundOpacity: Token<Float> = TokenReference { Mobius.styles.textField.selectionBackgroundOpacity }
}