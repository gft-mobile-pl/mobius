package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Styles
import com.gft.designsystem.Token

interface MobiusStyles : Styles {
    val screenStyle: ScreenStyle
    val contentStyle: ContentStyle
    val contentElementSpacerStyle: ContentElementSpacerStyle
    val scrollableContentStyle: ContentStyle
    val buttonStyle: ButtonStyle
    val outlinedButtonStyle: ButtonStyle
    val elevatedButtonStyle: ButtonStyle
    val filledTonalButtonStyle: ButtonStyle
    val textButtonStyle: ButtonStyle
    val radioButtonStyle: RadioButtonStyle
    val iconSizeStyle: IconSizeStyle
    val tab: TabStyle
    val primaryTabRow: TabRowStyle
    val secondaryTabRow: TabRowStyle
    val primaryScrollableTabRow: ScrollableTabRowStyle
    val secondaryScrollableTabRow: ScrollableTabRowStyle
    val text: Token<TextStyle>
    val textField: TextFieldStyle
    val outlinedTextField: TextFieldStyle
    val horizontalDivider: HorizontalDividerStyle
    val switchStyle: SwitchStyle
    val checkboxStyle: CheckboxStyle
    val timePickerStyle: TimePickerStyle
    val timeInputStyle: TimeInputStyle
}
