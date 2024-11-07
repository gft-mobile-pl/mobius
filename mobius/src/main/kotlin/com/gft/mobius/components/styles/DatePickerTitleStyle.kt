package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface DatePickerTitleStyleValues : StyleValues {
    val textStyle: TextStyle
    val padding: PaddingValues
}

interface DatePickerTitleStyle : Style {
    val textStyle: Token<TextStyle>
    val padding: Token<PaddingValues>
}

@Composable
fun DatePickerTitleStyle.resolve() = produceStyleValues { style ->
    object : DatePickerTitleStyleValues {
        override val textStyle = style.textStyle.resolve()
        override val padding = style.padding.resolve()
    }
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
