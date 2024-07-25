package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Styles
import com.gft.designsystem.Token

interface MobiusStyles : Styles {
    val tab: TabStyle
    val primaryTabRow: TabRowStyle
    val secondaryTabRow: TabRowStyle
    val primaryScrollableTabRow: ScrollableTabRowStyle
    val secondaryScrollableTabRow: ScrollableTabRowStyle
    val text: Token<TextStyle>
    val textField: TextFieldStyle
    val outlinedTextField: TextFieldStyle
    val horizontalDivider: HorizontalDividerStyle
}