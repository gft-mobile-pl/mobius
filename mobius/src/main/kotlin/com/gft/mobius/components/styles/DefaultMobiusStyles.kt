package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Token

open class DefaultMobiusStyles : MobiusStyles {
    override val text: Token<TextStyle> = DefaultTextStyle
    override val textField: TextFieldStyle = DefaultTextFieldStyle()
    override val outlinedTextField: TextFieldStyle = DefaultOutlinedTextFieldStyle()
    override val horizontalDivider: HorizontalDividerStyle = DefaultHorizontalDividerStyle()
}
