package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface DatePickerTitleStyle : Style {
    val textStyle: Token<TextStyle>
    val padding: Token<PaddingValues>
}

open class DefaultDatePickerTitleStyle : DatePickerTitleStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.datePickerStyle.titleTextStyle }
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension24,
            end = MobiusReferenceDimensions.Dimension12,
            top = MobiusReferenceDimensions.Dimension16
        )
    )
}

open class DefaultDateRangePickerTitleStyle : DatePickerTitleStyle {
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.dateRangePickerStyle.titleTextStyle }
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension64,
            end = MobiusReferenceDimensions.Dimension12
        )
    )
}
