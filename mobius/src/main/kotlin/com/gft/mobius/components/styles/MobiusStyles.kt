package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Styles
import com.gft.designsystem.Token

interface MobiusStyles : Styles {
    val scaffoldStyle: ScaffoldStyle
    val navigationBarStyle: NavigationBarStyle
    val navigationBarItemStyle: NavigationBarItemStyle
    val drawerStyle: DrawerStyle
    val drawerStyleVariant: DrawerStyle
    val verticalNavigationStyle: VerticalNavigationStyle
    val verticalNavigationItemStyle: VerticalNavigationItemStyle
    val navigationRailStyle: NavigationRailStyle
    val navigationRailItemStyle: NavigationRailItemStyle
    val screenStyle: ScreenStyle
    val dialogScreenStyle: DialogScreenStyle
    val contentStyle: ContentStyle
    val scrollableContentStyle: ContentStyle
    val dialogContentStyle: ContentStyle
    val dialogScrollableContentStyle: ContentStyle
    val headerContentStyle: ContentStyle
    val dialogHeaderContentStyle: ContentStyle
    val groupStyle: GroupStyle
    val cardStyle: CardStyle
    val outlinedCardStyle: CardStyle
    val elevatedCardStyle: CardStyle
    val buttonStyle: ButtonStyle
    val outlinedButtonStyle: ButtonStyle
    val elevatedButtonStyle: ButtonStyle
    val filledTonalButtonStyle: ButtonStyle
    val textButtonStyle: ButtonStyle
    val floatingActionButtonStyle: FloatingActionButtonStyle
    val secondaryFloatingActionButtonStyle: FloatingActionButtonStyle
    val prominentFloatingActionButtonStyle: FloatingActionButtonStyle
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
    val verticalDivider: VerticalDividerStyle
    val switchStyle: SwitchStyle
    val checkboxStyle: CheckboxStyle
    val timePickerStyle: TimePickerStyle
    val timeInputStyle: TimeInputStyle
    val datePickerStyle: DatePickerStyle
    val datePickerTitleStyle: DatePickerTitleStyle
    val datePickerHeadlineStyle: DatePickerHeadlineStyle
    val dateRangePickerStyle: DateRangePickerStyle
    val dateRangePickerTitleStyle: DatePickerTitleStyle
    val dateRangePickerHeadlineStyle: DatePickerHeadlineStyle
    val tooltipStyle: TooltipStyle
    val infoBoxStyle: InfoBoxStyle
    val infoBoxPositionProviderStyle: InfoBoxPositionProviderStyle
    val sliderThumbStyle: SliderThumbStyle
    val sliderTrackStyle: SliderTrackStyle
    val sliderTooltipStyle: TooltipStyle
}
