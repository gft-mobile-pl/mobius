package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.DatePickerFormatter
import com.gft.mobius.components.DefaultDatePickerFormatter

interface DatePickerStyleValues : StyleValues {
    val containerColor: Color
    val titleColor: Color
    val titleTextStyle: TextStyle
    val headlineContentColor: Color
    val headlineTextStyle: TextStyle
    val weekdayContentColor: Color
    val navigationContentColor: Color
    val yearContentColor: Color
    val disabledYearContentColor: Color
    val currentYearContentColor: Color
    val selectedYearContentColor: Color
    val disabledSelectedYearContentColor: Color
    val selectedYearContainerColor: Color
    val disabledSelectedYearContainerColor: Color
    val dayContentColor: Color
    val disabledDayContentColor: Color
    val selectedDayContentColor: Color
    val disabledSelectedDayContentColor: Color
    val selectedDayContainerColor: Color
    val disabledSelectedDayContainerColor: Color
    val todayContentColor: Color
    val todayDateBorderColor: Color
    val dividerColor: Color
    val dateTextFieldColors: TextFieldColors
    val modeToggleVisible: Boolean
    val dateFormatter: DatePickerFormatter
}

interface DatePickerStyle : Style {
    val containerColor: Token<Color>
    val titleColor: Token<Color>
    val titleTextStyle: Token<TextStyle>
    val headlineContentColor: Token<Color>
    val headlineTextStyle: Token<TextStyle>
    val weekdayContentColor: Token<Color>
    val navigationContentColor: Token<Color>
    val yearContentColor: Token<Color>
    val disabledYearContentColor: Token<Color>
    val currentYearContentColor: Token<Color>
    val selectedYearContentColor: Token<Color>
    val disabledSelectedYearContentColor: Token<Color>
    val selectedYearContainerColor: Token<Color>
    val disabledSelectedYearContainerColor: Token<Color>
    val dayContentColor: Token<Color>
    val disabledDayContentColor: Token<Color>
    val selectedDayContentColor: Token<Color>
    val disabledSelectedDayContentColor: Token<Color>
    val selectedDayContainerColor: Token<Color>
    val disabledSelectedDayContainerColor: Token<Color>
    val todayContentColor: Token<Color>
    val todayDateBorderColor: Token<Color>
    val dividerColor: Token<Color>
    val dateTextFieldColorTokens: Token<TextFieldColorTokens>
    val modeToggleVisible: Token<Boolean>
    val datePickerFormatter: Token<DatePickerFormatter>
}

@Composable
fun DatePickerStyle.resolve() = produceStyleValues { style ->
    object : DatePickerStyleValues {
        override val containerColor = style.containerColor.resolve()
        override val titleColor = style.titleColor.resolve()
        override val titleTextStyle = style.titleTextStyle.resolve()
        override val headlineContentColor = style.headlineContentColor.resolve()
        override val headlineTextStyle = style.headlineTextStyle.resolve()
        override val weekdayContentColor = style.weekdayContentColor.resolve()
        override val navigationContentColor = style.navigationContentColor.resolve()
        override val yearContentColor = style.yearContentColor.resolve()
        override val disabledYearContentColor = style.disabledYearContentColor.resolve()
        override val currentYearContentColor = style.currentYearContentColor.resolve()
        override val selectedYearContentColor = style.selectedYearContentColor.resolve()
        override val disabledSelectedYearContentColor = style.disabledSelectedYearContentColor.resolve()
        override val selectedYearContainerColor = style.selectedYearContainerColor.resolve()
        override val disabledSelectedYearContainerColor = style.disabledSelectedYearContainerColor.resolve()
        override val dayContentColor = style.dayContentColor.resolve()
        override val disabledDayContentColor = style.disabledDayContentColor.resolve()
        override val selectedDayContentColor = style.selectedDayContentColor.resolve()
        override val disabledSelectedDayContentColor = style.disabledSelectedDayContentColor.resolve()
        override val selectedDayContainerColor = style.selectedDayContainerColor.resolve()
        override val disabledSelectedDayContainerColor = style.disabledSelectedDayContainerColor.resolve()
        override val todayContentColor = style.todayContentColor.resolve()
        override val todayDateBorderColor = style.todayDateBorderColor.resolve()
        override val dividerColor = style.dividerColor.resolve()
        override val dateTextFieldColors = object : TextFieldColors {
            val textFieldColors = style.dateTextFieldColorTokens.resolve()
            override val selectionHandleColor = textFieldColors.selectionHandleColor.resolve()
            override val selectionBackgroundColor = textFieldColors.selectionBackgroundColor.resolve()
            override val focusedTextColor = textFieldColors.focusedTextColor.resolve()
            override val unfocusedTextColor = textFieldColors.unfocusedTextColor.resolve()
            override val disabledTextColor = textFieldColors.disabledTextColor.resolve()
            override val errorTextColor = textFieldColors.errorTextColor.resolve()
            override val focusedContainerColor = textFieldColors.focusedContainerColor.resolve()
            override val unfocusedContainerColor = textFieldColors.unfocusedContainerColor.resolve()
            override val disabledContainerColor = textFieldColors.disabledContainerColor.resolve()
            override val errorContainerColor = textFieldColors.errorContainerColor.resolve()
            override val cursorColor = textFieldColors.cursorColor.resolve()
            override val errorCursorColor = textFieldColors.errorCursorColor.resolve()
            override val focusedIndicatorColor = textFieldColors.focusedIndicatorColor.resolve()
            override val unfocusedIndicatorColor = textFieldColors.unfocusedIndicatorColor.resolve()
            override val disabledIndicatorColor = textFieldColors.disabledIndicatorColor.resolve()
            override val errorIndicatorColor = textFieldColors.errorIndicatorColor.resolve()
            override val focusedLeadingIconColor = textFieldColors.focusedLeadingIconColor.resolve()
            override val unfocusedLeadingIconColor = textFieldColors.unfocusedLeadingIconColor.resolve()
            override val disabledLeadingIconColor = textFieldColors.disabledLeadingIconColor.resolve()
            override val errorLeadingIconColor = textFieldColors.errorLeadingIconColor.resolve()
            override val focusedTrailingIconColor = textFieldColors.focusedTrailingIconColor.resolve()
            override val unfocusedTrailingIconColor = textFieldColors.unfocusedTrailingIconColor.resolve()
            override val disabledTrailingIconColor = textFieldColors.disabledTrailingIconColor.resolve()
            override val errorTrailingIconColor = textFieldColors.errorTrailingIconColor.resolve()
            override val focusedLabelColor = textFieldColors.focusedLabelColor.resolve()
            override val unfocusedLabelColor = textFieldColors.unfocusedLabelColor.resolve()
            override val disabledLabelColor = textFieldColors.disabledLabelColor.resolve()
            override val errorLabelColor = textFieldColors.errorLabelColor.resolve()
            override val focusedPlaceholderColor = textFieldColors.focusedPlaceholderColor.resolve()
            override val unfocusedPlaceholderColor = textFieldColors.unfocusedPlaceholderColor.resolve()
            override val disabledPlaceholderColor = textFieldColors.disabledPlaceholderColor.resolve()
            override val errorPlaceholderColor = textFieldColors.errorPlaceholderColor.resolve()
            override val focusedSupportingTextColor = textFieldColors.focusedSupportingTextColor.resolve()
            override val unfocusedSupportingTextColor = textFieldColors.unfocusedSupportingTextColor.resolve()
            override val disabledSupportingTextColor = textFieldColors.disabledSupportingTextColor.resolve()
            override val errorSupportingTextColor = textFieldColors.errorSupportingTextColor.resolve()
            override val focusedPrefixColor = textFieldColors.focusedPrefixColor.resolve()
            override val unfocusedPrefixColor = textFieldColors.unfocusedPrefixColor.resolve()
            override val disabledPrefixColor = textFieldColors.disabledPrefixColor.resolve()
            override val errorPrefixColor = textFieldColors.errorPrefixColor.resolve()
            override val focusedSuffixColor = textFieldColors.focusedSuffixColor.resolve()
            override val unfocusedSuffixColor = textFieldColors.unfocusedSuffixColor.resolve()
            override val disabledSuffixColor = textFieldColors.disabledSuffixColor.resolve()
            override val errorSuffixColor = textFieldColors.errorSuffixColor.resolve()
        }
        override val modeToggleVisible = style.modeToggleVisible.resolve()
        override val dateFormatter: DatePickerFormatter = style.datePickerFormatter.resolve()
    }
}

open class DefaultDatePickerStyle : DatePickerStyle {
    override val containerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHigh }
    override val titleColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val titleTextStyle: Token<TextStyle> = Token { Mobius.typography.labelLarge }
    override val headlineContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val headlineTextStyle: Token<TextStyle> = Token { Mobius.typography.headlineLarge }
    override val weekdayContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val navigationContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val yearContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledYearContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val currentYearContentColor: Token<Color> = Token { Mobius.colors.primary }
    override val selectedYearContentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val disabledSelectedYearContentColor: Token<Color> = Token { Mobius.colors.onPrimary.copy(alpha = 0.38f) }
    override val selectedYearContainerColor: Token<Color> = Token { Mobius.colors.primary }
    override val disabledSelectedYearContainerColor: Token<Color> = Token { Mobius.colors.primary.copy(alpha = 0.38f) }
    override val dayContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledDayContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val selectedDayContentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val disabledSelectedDayContentColor: Token<Color> = Token { Mobius.colors.onPrimary.copy(alpha = 0.38f) }
    override val selectedDayContainerColor: Token<Color> = Token { Mobius.colors.primary }
    override val disabledSelectedDayContainerColor: Token<Color> = Token { Mobius.colors.primary.copy(alpha = 0.38f) }
    override val todayContentColor: Token<Color> = Token { Mobius.colors.primary }
    override val todayDateBorderColor: Token<Color> = Token { Mobius.colors.primary }
    override val dividerColor: Token<Color> = Token { Mobius.colors.outlineVariant }
    override val dateTextFieldColorTokens: Token<TextFieldColorTokens> = Token { Mobius.styles.outlinedTextField }
    override val modeToggleVisible: Token<Boolean> = Token(true)
    override val datePickerFormatter: Token<DatePickerFormatter> = Token(DefaultDatePickerFormatter())
}
