package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.NavigationBar
import com.gft.mobius.components.NavigationBarItem
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.styles.DefaultNavigationBarItemStyle
import com.gft.mobius.components.styles.DefaultNavigationBarStyle
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility.WhenSelected

@Composable
fun MobiusNavigationBarPresentation() {
    Mobius {
        Screen {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                var selectedItemIndex by remember { mutableIntStateOf(0) }
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedItemIndex == 0,
                        onClick = { selectedItemIndex = 0 },
                        icon = { Icon(drawableResId = R.drawable.ic_home, contentDescription = null) },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 1,
                        onClick = { selectedItemIndex = 1 },
                        icon = { Icon(drawableResId = R.drawable.ic_account, contentDescription = null) },
                        label = { Text("Account") }
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 2,
                        onClick = { selectedItemIndex = 2 },
                        icon = { Icon(drawableResId = R.drawable.ic_settings, contentDescription = null) },
                        label = { Text("Settings") }
                    )
                }
                ElementSpacer()
                NavigationBar(style = customNavigationBarStyle()) {
                    NavigationBarItem(
                        selected = selectedItemIndex == 0,
                        onClick = { selectedItemIndex = 0 },
                        icon = { Icon(drawableResId = R.drawable.ic_home, contentDescription = null) },
                        label = { Text("Home") },
                        style = customNavigationBarItemStyle()
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 1,
                        onClick = { selectedItemIndex = 1 },
                        icon = { Icon(drawableResId = R.drawable.ic_account, contentDescription = null) },
                        label = { Text("Account") },
                        style = customNavigationBarItemStyle()
                    )
                    NavigationBarItem(
                        selected = selectedItemIndex == 2,
                        onClick = { selectedItemIndex = 2 },
                        icon = { Icon(drawableResId = R.drawable.ic_settings, contentDescription = null) },
                        label = { Text("Settings") },
                        style = customNavigationBarItemStyle()
                    )
                }
            }
        }
    }
}

@Composable
fun customNavigationBarStyle() = object : DefaultNavigationBarStyle() {
    override val shape: Token<Shape?> = Token(RoundedCornerShape(20.dp))
    override val padding = Token(PaddingValues(20.dp))
}

@Composable
private fun customNavigationBarItemStyle() = object : DefaultNavigationBarItemStyle() {
    override val labelVisibility = Token(WhenSelected)
}
