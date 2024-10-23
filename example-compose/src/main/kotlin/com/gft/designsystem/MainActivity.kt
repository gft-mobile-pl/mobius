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
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.gft.mobius.components.Button
import com.gft.mobius.components.Text

private const val menuDestination = "menuDestination"
private const val scaffoldDestination = "scaffoldDestination"
private const val topAppBarDestination = "topAppBarDestination"
private const val navigationBarDestination = "navigationBarDestination"
private const val navigationDrawerDestination = "navigationDrawerDestination"
private const val navigationRailDestination = "navigationRailDestination"
private const val bottomAppBarDestination = "bottomAppBarDestination"
private const val containersDestination = "containersDestination"
private const val headerDestination = "headerDestination"
private const val footerDestination = "footerDestination"
private const val cardsDestination = "cardsDestination"
private const val dialogScreenDestination = "dialogScreenDestination"
private const val dialogScreenSizingDestination = "dialogScreenSizingDestination"
private const val popUpDialogDestination = "popUpDialogDestination"
private const val lightColorsDestination = "lightColorsDestination"
private const val darkColorsDestination = "darkColorsDestination"
private const val typographyDestination = "typographyDestination"
private const val textFieldsDestination = "textFieldsDestination"
private const val surfaceDestination = "surfaceDestination"
private const val tabsDestination = "tabsDestination"
private const val buttonsDestination = "buttonsDestination"
private const val iconButtonsDestination = "iconButtonsDestination"
private const val floatingActionButtonsDestination = "floatingActionButtonsDestination"
private const val radioButtonsDestination = "radioButtonsDestination"
private const val switchDestination = "switchDestination"
private const val checkboxDestination = "checkboxDestination"
private const val timePickerDestination = "timePickerDestination"
private const val timeInputDestination = "timeInputDestination"
private const val datePickerDestination = "datePickerDestination"
private const val dateRangePickerDestination = "dateRangePickerDestination"
private const val tooltipDestination = "tooltipDestination"
private const val sliderDestination = "sliderDestination"
private const val rangeSliderDestination = "rangeSliderDestination"
private const val swipeToDismissBoxDestination = "swipeToDismissBoxDestination"
private const val progressIndicatorDestination = "progressIndicatorDestination"
private const val labelDestination = "labelDestination"
private const val dropdownMenuDestination = "dropdownMenuDestination"
private const val listItemDestination = "listItemDestination"

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
                            .padding(16.dp)
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
                            text = "Scaffold",
                            onClick = { navController.navigate(scaffoldDestination) }
                        )
                        MenuButton(
                            text = "Top app bar",
                            onClick = { navController.navigate(topAppBarDestination) }
                        )
                        MenuButton(
                            text = "Navigation Bar",
                            onClick = { navController.navigate(navigationBarDestination) }
                        )
                        MenuButton(
                            text = "Navigation Drawer",
                            onClick = { navController.navigate(navigationDrawerDestination) }
                        )
                        MenuButton(
                            text = "NavigationRail",
                            onClick = { navController.navigate(navigationRailDestination) }
                        )
                        MenuButton(
                            text = "Bottom app bar",
                            onClick = { navController.navigate(bottomAppBarDestination) }
                        )
                        MenuButton(
                            text = "Containers",
                            onClick = { navController.navigate(containersDestination) }
                        )
                        MenuButton(
                            text = "Headers",
                            onClick = { navController.navigate(headerDestination) }
                        )
                        MenuButton(
                            text = "Footers",
                            onClick = { navController.navigate(footerDestination) }
                        )
                        MenuButton(
                            text = "Cards",
                            onClick = { navController.navigate(cardsDestination) }
                        )
                        MenuButton(
                            text = "Dialog screen",
                            onClick = { navController.navigate(dialogScreenDestination) }
                        )
                        MenuButton(
                            text = "Dialog screen sizing",
                            onClick = { navController.navigate(dialogScreenSizingDestination) }
                        )
                        MenuButton(
                            text = "PopUp dialog",
                            onClick = { navController.navigate(popUpDialogDestination) }
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
                            text = "Icon Buttons",
                            onClick = { navController.navigate(iconButtonsDestination) }
                        )
                        MenuButton(
                            text = "Floating Action Buttons",
                            onClick = { navController.navigate(floatingActionButtonsDestination) })
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
                        MenuButton(
                            text = "DatePicker",
                            onClick = { navController.navigate(datePickerDestination) }
                        )
                        MenuButton(
                            text = "DateRangePicker",
                            onClick = { navController.navigate(dateRangePickerDestination) }
                        )
                        MenuButton(
                            text = "Tooltip",
                            onClick = { navController.navigate(tooltipDestination) }
                        )
                        MenuButton(
                            text = "Slider",
                            onClick = { navController.navigate(sliderDestination) }
                        )
                        MenuButton(
                            text = "RangeSlider",
                            onClick = { navController.navigate(rangeSliderDestination) }
                        )
                        MenuButton(
                            text = "SwipeToDismissBox",
                            onClick = { navController.navigate(swipeToDismissBoxDestination) }
                        )
                        MenuButton(
                            text = "Progress indicator",
                            onClick = { navController.navigate(progressIndicatorDestination) }
                        )
                        MenuButton(
                            text = "Label",
                            onClick = { navController.navigate(labelDestination) }
                        )
                        MenuButton(
                            text = "Dropdown menu",
                            onClick = { navController.navigate(dropdownMenuDestination) }
                        )
                        MenuButton(
                            text = "List Item",
                            onClick = { navController.navigate(listItemDestination) }
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

                composable(scaffoldDestination) {
                    MobiusScaffoldPresentation()
                }

                composable(topAppBarDestination) {
                    MobiusTopAppBarPresentation()
                }

                composable(navigationBarDestination) {
                    MobiusNavigationBarPresentation()
                }

                composable(navigationDrawerDestination) {
                    MobiusNavigationDrawerPresentation()
                }

                composable(navigationRailDestination) {
                    MobiusNavigationRailPresentation()
                }

                composable(bottomAppBarDestination) {
                    MobiusBottomAppBarPresentation()
                }

                composable(containersDestination) {
                    MobiusContainersPresentation()
                }

                composable(headerDestination) {
                    MobiusHeaderPresentation()
                }

                composable(footerDestination) {
                    MobiusFooterPresentation()
                }

                composable(cardsDestination) {
                    MobiusCardsPresentation()
                }

                composable(dialogScreenDestination) {
                    MobiusDialogScreenPresentation()
                }

                dialog(dialogScreenSizingDestination) {
                    MobiusDialogScreenSizingPresentation()
                }

                composable(popUpDialogDestination) {
                    MobiusPopUpDialogPresentation()
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

                composable(iconButtonsDestination) {
                    MobiusIconButtonPresentation()
                }

                composable(floatingActionButtonsDestination) {
                    MobiusFloatingActionButtonPresentation()
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

                composable(datePickerDestination) {
                    MobiusDatePickerPresentation()
                }

                composable(dateRangePickerDestination) {
                    MobiusDateRangePickerPresentation()
                }

                composable(tooltipDestination) {
                    MobiusTooltipPresentation()
                }

                composable(sliderDestination) {
                    MobiusSliderPresentation()
                }

                composable(rangeSliderDestination) {
                    MobiusRangeSliderPresentation()
                }

                composable(swipeToDismissBoxDestination) {
                    MobiusSwipeToDismissBoxPresentation()
                }

                composable(progressIndicatorDestination) {
                    MobiusProgressIndicatorPresentation()
                }

                composable(labelDestination) {
                    MobiusLabelPresentation()
                }

                composable(dropdownMenuDestination) {
                    MobiusDropdownMenuPresentation()
                }

                composable(listItemDestination) {
                    MobiusListItemPresentation()
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
