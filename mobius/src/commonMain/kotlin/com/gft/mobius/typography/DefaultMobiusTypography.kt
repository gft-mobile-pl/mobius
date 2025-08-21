package com.gft.mobius.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.gft.designsystem.ModuleInitialization
import com.gft.mobius.references.MobiusReferenceFonts

open class DefaultMobiusTypography : MobiusTypography {

    @ModuleInitialization
    @Composable
    override fun initialize() {
        MobiusReferenceFonts.loadFonts()
    }

    override val displayLarge: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 56.sp,
            lineHeight = 66.sp,
            letterSpacing = (-0.25).sp
        )
    }
    override val displayMedium: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 44.sp,
            lineHeight = 52.sp,
            letterSpacing = 0.sp
        )
    }
    override val displaySmall: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp,
            lineHeight = 42.sp,
            letterSpacing = 0.sp
        )
    }
    override val headlineLarge: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        )
    }
    override val headlineMedium: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        )
    }
    override val headlineSmall: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        )
    }
    override val titleLarge: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 25.sp,
            letterSpacing = 0.sp
        )
    }
    override val titleMedium: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        )
    }
    override val titleSmall: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = (0.1).sp
        )
    }
    override val labelLarge: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = (0.1).sp
        )
    }
    override val labelMedium: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 13.sp,
            letterSpacing = (0.5).sp
        )
    }
    override val labelSmall: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 12.sp,
            letterSpacing = (0.5).sp
        )
    }
    override val bodyLarge: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 21.sp,
            letterSpacing = (0.5).sp
        )
    }
    override val bodyMedium: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            letterSpacing = (0.25).sp
        )
    }
    override val bodySmall: TextStyle by lazy {
        DefaultTextStyle.copy(
            fontFamily = MobiusReferenceFonts.Figtree,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = (0.4).sp
        )
    }
}

private val DefaultTextStyle = TextStyle.Default.copy(
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    ),
)
