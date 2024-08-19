package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Styles
import com.gft.designsystem.Token

interface MobiusStyles : Styles {
    val screenStyle: ScreenStyle
    val dialogScreenStyle: DialogScreenStyle
    val contentStyle: ContentStyle
    val contentElementSpacerStyle: ContentElementSpacerStyle
    val scrollableContentStyle: ContentStyle
    val groupStyle: GroupStyle
    val groupElementSpacerStyle: GroupElementSpacerStyle
    val cardStyle: CardStyle
    val outlinedCardStyle: CardStyle
    val elevatedCardStyle: CardStyle
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
    val tooltipStyle: TooltipStyle
    val infoBoxStyle: InfoBoxStyle
    val infoBoxPositionProviderStyle: InfoBoxPositionProviderStyle
    val sliderThumbStyle: SliderThumbStyle
    val sliderTrackStyle: SliderTrackStyle
    val sliderTooltipStyle: TooltipStyle
}
