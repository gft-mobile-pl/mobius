package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Icon
import com.gft.mobius.components.NavigationRail
import com.gft.mobius.components.NavigationRailItem
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.styles.DefaultNavigationRailItemStyle
import com.gft.mobius.components.styles.DefaultNavigationRailStyle
import com.gft.mobius.components.styles.NavigationRailItemStyle
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility.WhenSelected
import com.gft.mobius.components.styles.NavigationRailStyle

@Composable
fun MobiusNavigationRailPresentation() {
    Mobius {
        Screen {
            Row(modifier = Modifier.fillMaxSize()) {
                var selectedNavigationItem by remember { mutableIntStateOf(0) }
                NavigationRail {
                    NavigationRailItem(
                        selected = selectedNavigationItem == 0,
                        onClick = { selectedNavigationItem = 0 },
                        icon = { Icon(drawableResId = R.drawable.ic_home, contentDescription = null) },
                        label = { Text("Home") }
                    )
                    NavigationRailItem(
                        selected = selectedNavigationItem == 1,
                        onClick = { selectedNavigationItem = 1 },
                        icon = { Icon(drawableResId = R.drawable.ic_account, contentDescription = null) },
                        label = { Text("Account") }
                    )
                    NavigationRailItem(
                        selected = selectedNavigationItem == 2,
                        onClick = { selectedNavigationItem = 2 },
                        icon = { Icon(drawableResId = R.drawable.ic_settings, contentDescription = null) },
                        label = { Text("Settings") }
                    )
                }

                NavigationRail(style = customNavigationRailStyle()) {
                    NavigationRailItem(
                        selected = selectedNavigationItem == 0,
                        onClick = { selectedNavigationItem = 0 },
                        icon = { Icon(drawableResId = R.drawable.ic_home, contentDescription = null) },
                        label = { Text("Home") },
                        style = customNavigationRailItemStyle()
                    )
                    NavigationRailItem(
                        selected = selectedNavigationItem == 1,
                        onClick = { selectedNavigationItem = 1 },
                        icon = { Icon(drawableResId = R.drawable.ic_account, contentDescription = null) },
                        label = { Text("Account") },
                        style = customNavigationRailItemStyle()
                    )
                    NavigationRailItem(
                        selected = selectedNavigationItem == 2,
                        onClick = { selectedNavigationItem = 2 },
                        icon = { Icon(drawableResId = R.drawable.ic_settings, contentDescription = null) },
                        label = { Text("Settings") },
                        style = customNavigationRailItemStyle()
                    )
                }
            }
        }
    }
}

@Composable
private fun customNavigationRailItemStyle(): NavigationRailItemStyle {
    val defaultStyle = Mobius.styles.navigationRailItemStyle
    return remember(defaultStyle) {
        object : NavigationRailItemStyle by defaultStyle {
            override val labelVisibility = Token(WhenSelected)
        }
    }
}

@Composable
private fun customNavigationRailStyle(): NavigationRailStyle {
    val defaultStyle = Mobius.styles.navigationRailStyle
    return remember(defaultStyle) {
        object : NavigationRailStyle by defaultStyle {
            override val arrangement: Token<Arrangement.Vertical> = Token(Arrangement.Center)
            override val shape: Token<Shape?> = Token { RoundedCornerShape(16.dp) }
            override val backgroundColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
        }
    }
}
