package com.gft.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.gft.mobius.components.Button
import com.gft.mobius.components.Text

private const val menuDestination = "menuDestination"
private const val lightColorsDestination = "lightColorsDestination"
private const val darkColorsDestination = "darkColorsDestination"
private const val typographyDestination = "typographyDestination"
private const val textFieldsDestination = "textFieldsDestination"
private const val surfaceDestination = "surfaceDestination"
private const val tabsDestination = "tabsDestination"
private const val buttonsDestination = "buttonsDestination"
private const val radioButtonsDestination = "radioButtonsDestination"
private const val switchDestination = "switchDestination"
private const val checkboxDestination = "checkboxDestination"
private const val timePickerDestination = "timePickerDestination"
private const val timeInputDestination = "timeInputDestination"

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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MenuButton(
                            text = "Light Colors",
                            onClick = { navController.navigate(lightColorsDestination) }
                        )
                        MenuButton(
                            text = "Dark Colors",
                            onClick = { navController.navigate(darkColorsDestination) }
                        )
                        MenuButton(
                            text = "Typography",
                            onClick = { navController.navigate(typographyDestination) }
                        )
                        MenuButton(
                            text = "Surface",
                            onClick = { navController.navigate(surfaceDestination) }
                        )
                        MenuButton(
                            text = "TextFields",
                            onClick = { navController.navigate(textFieldsDestination) }
                        )
                        MenuButton(
                            text = "Tabs",
                            onClick = { navController.navigate(tabsDestination) }
                        )
                        MenuButton(
                            text = "Buttons",
                            onClick = { navController.navigate(buttonsDestination) }
                        )
                        MenuButton(
                            text = "Radio Buttons",
                            onClick = { navController.navigate(radioButtonsDestination) }
                        )
                        MenuButton(
                            text = "Switch",
                            onClick = { navController.navigate(switchDestination) }
                        )
                        MenuButton(
                            text = "Checkbox",
                            onClick = { navController.navigate(checkboxDestination) }
                        )
                        MenuButton(
                            text = "TimePicker",
                            onClick = { navController.navigate(timePickerDestination) }
                        )
                        MenuButton(
                            text = "TimeInput",
                            onClick = { navController.navigate(timeInputDestination) }
                        )
                    }
                }

                composable(lightColorsDestination) {
                    MobiusColorsPresentation(MobiusColorsMode.Light)
                }

                composable(darkColorsDestination) {
                    MobiusColorsPresentation(MobiusColorsMode.Dark)
                }

                composable(typographyDestination) {
                    MobiusTypographyPresentation()
                }

                composable(textFieldsDestination) {
                    MobiusTextFields()
                }

                composable(surfaceDestination) {
                    MobiusSurfacePresentation()
                }

                composable(tabsDestination) {
                    MobiusTabsPresentation()
                }

                composable(buttonsDestination) {
                    MobiusButtonsPresentation()
                }

                composable(radioButtonsDestination) {
                    MobiusRadioButtonsPresentation()
                }

                composable(switchDestination) {
                    MobiusSwitchPresentation()
                }

                composable(checkboxDestination) {
                    MobiusCheckboxPresentation()
                }

                composable(timePickerDestination) {
                    MobiusTimePickerPresentation()
                }

                composable(timeInputDestination) {
                    MobiusTimeInputPresentation()
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
        modifier = Modifier.width(160.dp)
    ) {
        Text(text)
    }
}
