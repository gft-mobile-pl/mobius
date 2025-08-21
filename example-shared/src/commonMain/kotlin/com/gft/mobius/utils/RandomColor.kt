package com.gft.mobius.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random
import kotlin.random.nextInt

fun randomColor(minRed: Int = 0x80, minGreen: Int = 0x80, minBlue: Int = 0x80) = Color(
    Random.nextInt(minRed..0xff),
    Random.nextInt(minGreen..0xff),
    Random.nextInt(minBlue..0xff),
)
