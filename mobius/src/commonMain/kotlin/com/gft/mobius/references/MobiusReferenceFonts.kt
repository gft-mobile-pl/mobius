package com.gft.mobius.references

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import mobius.mobius.generated.resources.Res
import mobius.mobius.generated.resources.figtree_bold
import mobius.mobius.generated.resources.figtree_bold_italic
import mobius.mobius.generated.resources.figtree_italic
import mobius.mobius.generated.resources.figtree_medium
import mobius.mobius.generated.resources.figtree_medium_italic
import mobius.mobius.generated.resources.figtree_regular
import mobius.mobius.generated.resources.figtree_semi_bold
import mobius.mobius.generated.resources.figtree_semi_bold_italic
import org.jetbrains.compose.resources.Font

internal object MobiusReferenceFonts {
    lateinit var Figtree: FontFamily

    @Composable
    fun initializeFonts() {
        Figtree = FontFamily(
            Font(Res.font.figtree_regular, FontWeight.Normal, FontStyle.Normal),
            Font(Res.font.figtree_regular, FontWeight.W400, FontStyle.Normal),
            Font(Res.font.figtree_italic, FontWeight.Normal, FontStyle.Italic),
            Font(Res.font.figtree_italic, FontWeight.W400, FontStyle.Italic),
            Font(Res.font.figtree_bold, FontWeight.Bold, FontStyle.Normal),
            Font(Res.font.figtree_bold, FontWeight.W700, FontStyle.Normal),
            Font(Res.font.figtree_bold_italic, FontWeight.Bold, FontStyle.Italic),
            Font(Res.font.figtree_bold_italic, FontWeight.W700, FontStyle.Italic),
            Font(Res.font.figtree_medium, FontWeight.Medium, FontStyle.Normal),
            Font(Res.font.figtree_medium, FontWeight.W500, FontStyle.Normal),
            Font(Res.font.figtree_medium_italic, FontWeight.Medium, FontStyle.Italic),
            Font(Res.font.figtree_medium_italic, FontWeight.W500, FontStyle.Italic),
            Font(Res.font.figtree_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
            Font(Res.font.figtree_semi_bold, FontWeight.W600, FontStyle.Normal),
            Font(Res.font.figtree_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
            Font(Res.font.figtree_semi_bold_italic, FontWeight.W600, FontStyle.Italic),
        )
    }
}
