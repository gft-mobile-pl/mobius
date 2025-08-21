package com.gft.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Text

private const val menuDestination = "menuDestination"
private const val navigationDrawerDestination = "navigationDrawerDestination"
private const val iconButtonsDestination = "iconButtonsDestination"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = menuDestination
            ) {
                composable(menuDestination) {
                    Mobius {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("This example presents Android-only features. Check example-kmp-android to get familiar with all Mobius features.")
                            MenuButton(
                                text = "Navigation Drawer",
                                onClick = { navController.navigate(navigationDrawerDestination) }
                            )
                            MenuButton(
                                text = "Icon Buttons",
                                onClick = { navController.navigate(iconButtonsDestination) }
                            )
                        }
                    }
                }

                composable(navigationDrawerDestination) {
                    MobiusNavigationDrawerPresentation()
                }

                composable(iconButtonsDestination) {
                    MobiusIconButtonPresentation()
                }
            }
        }
    }
}

@Composable
private fun MenuButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(210.dp)
    ) {
        Text(text)
    }
}
