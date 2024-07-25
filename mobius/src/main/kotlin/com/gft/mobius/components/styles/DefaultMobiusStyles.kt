package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Token

open class DefaultMobiusStyles : MobiusStyles {
    override val tab: TabStyle = DefaultTabStyle()
    override val primaryTabRow: TabRowStyle = PrimaryTabRowStyle()
    override val secondaryTabRow: TabRowStyle = SecondaryTabRowStyle()
    override val primaryScrollableTabRow: ScrollableTabRowStyle = PrimaryScrollableTabRowStyle()
    override val secondaryScrollableTabRow: ScrollableTabRowStyle = SecondaryScrollableTabRowStyle()
    override val text: Token<TextStyle> = DefaultTextStyle
    override val textField: TextFieldStyle = DefaultTextFieldStyle()
    override val outlinedTextField: TextFieldStyle = DefaultOutlinedTextFieldStyle()
    override val horizontalDivider: HorizontalDividerStyle = DefaultHorizontalDividerStyle()
}
