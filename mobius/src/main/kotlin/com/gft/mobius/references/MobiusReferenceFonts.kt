package com.gft.mobius.references

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.gft.mobius.R

internal object MobiusReferenceFonts {
    val Figtree = FontFamily(
        Font(R.font.figtree_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.figtree_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.figtree_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.figtree_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.figtree_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.figtree_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    )
}
