package com.gft.mobius

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gft.mobius.components.Button
import com.gft.mobius.components.Text
import com.gft.mobius.presentation.MobiusBottomAppBarPresentation
import com.gft.mobius.presentation.MobiusButtonsPresentation
import com.gft.mobius.presentation.MobiusCardsPresentation
import com.gft.mobius.presentation.MobiusCheckboxPresentation
import com.gft.mobius.presentation.MobiusColorsMode
import com.gft.mobius.presentation.MobiusColorsPresentation
import com.gft.mobius.presentation.MobiusContainersPresentation
import com.gft.mobius.presentation.MobiusDatePickerPresentation
import com.gft.mobius.presentation.MobiusDateRangePickerPresentation
import com.gft.mobius.presentation.MobiusDialogScreenPresentation
import com.gft.mobius.presentation.MobiusDialogScreenSizingPresentation
import com.gft.mobius.presentation.MobiusDropdownMenuPresentation
import com.gft.mobius.presentation.MobiusFloatingActionButtonPresentation
import com.gft.mobius.presentation.MobiusFooterPresentation
import com.gft.mobius.presentation.MobiusHeaderPresentation
import com.gft.mobius.presentation.MobiusIconButtonPresentation
import com.gft.mobius.presentation.MobiusLabelPresentation
import com.gft.mobius.presentation.MobiusListItemPresentation
import com.gft.mobius.presentation.MobiusNavigationBarPresentation
import com.gft.mobius.presentation.MobiusNavigationDrawerPresentation
import com.gft.mobius.presentation.MobiusNavigationRailPresentation
import com.gft.mobius.presentation.MobiusPopUpDialogPresentation
import com.gft.mobius.presentation.MobiusProgressIndicatorPresentation
import com.gft.mobius.presentation.MobiusRadioButtonsPresentation
import com.gft.mobius.presentation.MobiusRangeSliderPresentation
import com.gft.mobius.presentation.MobiusScaffoldPresentation
import com.gft.mobius.presentation.MobiusSliderPresentation
import com.gft.mobius.presentation.MobiusSurfacePresentation
import com.gft.mobius.presentation.MobiusSwipeToDismissBoxPresentation
import com.gft.mobius.presentation.MobiusSwitchPresentation
import com.gft.mobius.presentation.MobiusTabsPresentation
import com.gft.mobius.presentation.MobiusTextFields
import com.gft.mobius.presentation.MobiusTimeInputPresentation
import com.gft.mobius.presentation.MobiusTimePickerPresentation
import com.gft.mobius.presentation.MobiusTooltipPresentation
import com.gft.mobius.presentation.MobiusTopAppBarPresentation
import com.gft.mobius.presentation.MobiusTypographyPresentation

internal const val rootDestination = "rootDestination"
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

@Composable
fun MobiusPresentation(
    currentDestination: MutableState<String> = remember { mutableStateOf(rootDestination) },
){
    AnimatedContent(
        targetState = currentDestination.value,
        transitionSpec = {
            fadeIn() togetherWith fadeOut()
        }
    ) { destination ->
        val goBackToMenu = { currentDestination.value = rootDestination }
        
        Box(modifier = Modifier.fillMaxSize()) {
            when (destination) {
                rootDestination -> Menu { targetDestination -> currentDestination.value = targetDestination }
                lightColorsDestination -> MobiusColorsPresentation(MobiusColorsMode.Light, onBack = goBackToMenu)
                darkColorsDestination -> MobiusColorsPresentation(MobiusColorsMode.Dark, onBack = goBackToMenu)
                typographyDestination -> MobiusTypographyPresentation(onBack = goBackToMenu)
                scaffoldDestination -> MobiusScaffoldPresentation(onBack = goBackToMenu)
                topAppBarDestination -> MobiusTopAppBarPresentation(onBack = goBackToMenu)
                navigationBarDestination -> MobiusNavigationBarPresentation(onBack = goBackToMenu)
                navigationDrawerDestination -> MobiusNavigationDrawerPresentation(onBack = goBackToMenu)
                navigationRailDestination -> MobiusNavigationRailPresentation(onBack = goBackToMenu)
                bottomAppBarDestination -> MobiusBottomAppBarPresentation(onBack = goBackToMenu)
                containersDestination -> MobiusContainersPresentation(onBack = goBackToMenu)
                headerDestination -> MobiusHeaderPresentation(onBack = goBackToMenu)
                footerDestination -> MobiusFooterPresentation(onBack = goBackToMenu)
                cardsDestination -> MobiusCardsPresentation(onBack = goBackToMenu)
                dialogScreenDestination -> Dialog(onDismissRequest = goBackToMenu) {
                    MobiusDialogScreenPresentation()
                }

                dialogScreenSizingDestination -> Dialog(onDismissRequest = goBackToMenu) {
                    MobiusDialogScreenSizingPresentation()
                }

                popUpDialogDestination -> MobiusPopUpDialogPresentation(onBack = goBackToMenu)
                textFieldsDestination -> MobiusTextFields(onBack = goBackToMenu)
                surfaceDestination -> MobiusSurfacePresentation(onBack = goBackToMenu)
                tabsDestination -> MobiusTabsPresentation(onBack = goBackToMenu)
                buttonsDestination -> MobiusButtonsPresentation(onBack = goBackToMenu)
                iconButtonsDestination -> MobiusIconButtonPresentation(onBack = goBackToMenu)
                floatingActionButtonsDestination -> MobiusFloatingActionButtonPresentation(onBack = goBackToMenu)
                radioButtonsDestination -> MobiusRadioButtonsPresentation(onBack = goBackToMenu)
                switchDestination -> MobiusSwitchPresentation(onBack = goBackToMenu)
                checkboxDestination -> MobiusCheckboxPresentation(onBack = goBackToMenu)
                timePickerDestination -> MobiusTimePickerPresentation(onBack = goBackToMenu)
                timeInputDestination -> MobiusTimeInputPresentation(onBack = goBackToMenu)
                datePickerDestination -> MobiusDatePickerPresentation(onBack = goBackToMenu)
                dateRangePickerDestination -> MobiusDateRangePickerPresentation(onBack = goBackToMenu)
                tooltipDestination -> MobiusTooltipPresentation(onBack = goBackToMenu)
                sliderDestination -> MobiusSliderPresentation(onBack = goBackToMenu)
                rangeSliderDestination -> MobiusRangeSliderPresentation(onBack = goBackToMenu)
                swipeToDismissBoxDestination -> MobiusSwipeToDismissBoxPresentation(onBack = goBackToMenu)
                progressIndicatorDestination -> MobiusProgressIndicatorPresentation(onBack = goBackToMenu)
                labelDestination -> MobiusLabelPresentation(onBack = goBackToMenu)
                dropdownMenuDestination -> MobiusDropdownMenuPresentation(onBack = goBackToMenu)
                listItemDestination -> MobiusListItemPresentation(onBack = goBackToMenu)
            }
        }
    }
}

private class MenuSection(
    val title: String,
    val items: List<MenuItem>,
)

private class MenuItem(
    val text: String,
    val destination: String,
)

private val menuSections = listOf(
    MenuSection(
        title = "Motive",
        items = listOf(
            MenuItem("Light Colors", lightColorsDestination),
            MenuItem("Dark Colors", darkColorsDestination),
            MenuItem("Typography", typographyDestination),
        )
    ),
    MenuSection(
        title = "Scaffold",
        items = listOf(
            MenuItem("Scaffold", scaffoldDestination),
            MenuItem("Navigation Drawer", navigationDrawerDestination),
            MenuItem("Navigation Rail", navigationRailDestination),
            MenuItem("Navigation Bar", navigationBarDestination),
            MenuItem("Top app bar", topAppBarDestination),
            MenuItem("Bottom app bar", bottomAppBarDestination),
            MenuItem("Tabs", tabsDestination),
        )
    ),
    MenuSection(
        title = "Block layout",
        items = listOf(
            MenuItem("Containers", containersDestination),
            MenuItem("Headers", headerDestination),
            MenuItem("Footers", footerDestination),
        )
    ),
    MenuSection(
        title = "Dialogs",
        items = listOf(
            MenuItem("Dialog screen", dialogScreenDestination),
            MenuItem("Dialog screen sizing", dialogScreenSizingDestination),
            MenuItem("PopUp dialog", popUpDialogDestination),
        )
    ),
    MenuSection(
        title = "List",
        items = listOf(
            MenuItem("List Item", listItemDestination),
        )
    ),
    MenuSection(
        title = "Elevated containers",
        items = listOf(
            MenuItem("Surface", surfaceDestination),
            MenuItem("Cards", cardsDestination),
            MenuItem("SwipeToDismissBox", swipeToDismissBoxDestination),
        )
    ),
    MenuSection(
        title = "Buttons",
        items = listOf(
            MenuItem("Buttons", buttonsDestination),
            MenuItem("Icon Buttons", iconButtonsDestination),
            MenuItem("Floating Action Buttons", floatingActionButtonsDestination),
        )
    ),
    MenuSection(
        title = "Info components",
        items = listOf(
            MenuItem("Label", labelDestination),
            MenuItem("Progress indicator", progressIndicatorDestination),
            MenuItem("Tooltip", tooltipDestination),
        )
    ),
    MenuSection(
        title = "Value selectors",
        items = listOf(
            MenuItem("Switch", switchDestination),
            MenuItem("Checkbox", checkboxDestination),
            MenuItem("Radio Buttons", radioButtonsDestination),
            MenuItem("Slider", sliderDestination),
            MenuItem("RangeSlider", rangeSliderDestination),
            MenuItem("Dropdown menu", dropdownMenuDestination),
            MenuItem("TextFields", textFieldsDestination),
        )
    ),
    MenuSection(
        title = "Time selectors",
        items = listOf(
            MenuItem("TimePicker", timePickerDestination),
            MenuItem("TimeInput", timeInputDestination),
            MenuItem("DatePicker", datePickerDestination),
            MenuItem("DateRangePicker", dateRangePickerDestination),
        )
    ),
)

@Composable
private fun Menu(
    onNavigateToDestination: (String) -> Unit,
) {
    Mobius {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            menuSections.forEach { section ->
                MenuSectionContent(
                    section = section,
                    onNavigateToDestination = onNavigateToDestination,
                )
            }
        }
    }
}

@Composable
private fun MenuSectionContent(
    section: MenuSection,
    onNavigateToDestination: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = section.title,
            style = Mobius.typography.titleLarge,
        )
        section.items.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                rowItems.forEach { item ->
                    MenuButton(
                        text = item.text,
                        onClick = { onNavigateToDestination(item.destination) },
                        modifier = Modifier.weight(1f),
                    )
                }
                if (rowItems.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun MenuButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
