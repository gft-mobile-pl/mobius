package com.gft.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gft.mobius.Mobius
import com.gft.mobius.colors.MobiusDarkColors

private const val startDestination = "startDestination"
private const val lightColorsDestination = "lightColorsDestination"
private const val darkColorsDestination = "darkColorsDestination"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                composable(startDestination) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextButton(
                            text = "Light Colors",
                            onClick = { navController.navigate(lightColorsDestination) }
                        )
                        TextButton(
                            text = "Dark Colors",
                            onClick = { navController.navigate(darkColorsDestination) }
                        )
                    }
                }

                composable(lightColorsDestination) {
                    Mobius {
                        MobiusColorsPresentation()
                    }
                }

                composable(darkColorsDestination) {
                    Mobius(
                        colors = MobiusDarkColors()
                    ) {
                        MobiusColorsPresentation()
                    }
                }
            }

        }
    }
}

@Composable
private fun TextButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Mobius.colors.primary)
            .padding(16.dp)
            .width(200.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            color = Mobius.colors.onPrimary
        )
    }

}
