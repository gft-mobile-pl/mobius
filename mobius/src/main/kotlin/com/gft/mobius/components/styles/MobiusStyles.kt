package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Styles
import com.gft.designsystem.Token

interface MobiusStyles : Styles {
    val text: Token<TextStyle>
    val textField: TextFieldStyle
    val outlinedTextField: TextFieldStyle
}