package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.DatePickerFormatter
import com.gft.mobius.components.DefaultDatePickerFormatter
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface DatePickerHeadlineStyle : Style {
    val textStyle: Token<TextStyle>
    val padding: Token<PaddingValues>
    val dateFormatter: Token<DatePickerFormatter>
}

open class DefaultDatePickerHeadlineStyle : DatePickerHeadlineStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.datePickerStyle.headlineTextStyle }
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension24,
            end = MobiusReferenceDimensions.Dimension12,
            bottom = MobiusReferenceDimensions.Dimension12
        )
    )
    override val dateFormatter: Token<DatePickerFormatter> = Token(DefaultDatePickerFormatter())
}

open class DefaultDateRangePickerHeadlineStyle : DatePickerHeadlineStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.dateRangePickerStyle.headlineTextStyle }
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension64,
            end = MobiusReferenceDimensions.Dimension12,
            bottom = MobiusReferenceDimensions.Dimension12
        )
    )
    override val dateFormatter: Token<DatePickerFormatter> = Token(DefaultDatePickerFormatter())
}
