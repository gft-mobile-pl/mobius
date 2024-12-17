package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.gft.compose.common.modifyIf
import com.gft.designsystem.ButtonsLayoutOptions.COLUMN
import com.gft.designsystem.ButtonsLayoutOptions.HORIZONTAL_FLOW
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Checkbox
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.Label
import com.gft.mobius.components.LabelPlacement
import com.gft.mobius.components.LargeElementSpacer
import com.gft.mobius.components.PopUpScreen
import com.gft.mobius.components.PopUpScreen.ScrollPolicy
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.TextButton
import com.gft.mobius.components.styles.DialogButtonsStyle
import com.gft.mobius.components.styles.DialogButtonsStyle.ButtonsLayout
import com.gft.mobius.components.styles.DialogButtonsStyle.ButtonsLayout.ButtonWidth
import com.gft.mobius.components.styles.PopUpScreenStyle

private const val popUpPresentationMenuDestination = "popUpSettingsDestination"
private const val popUpScreenDestination = "popUpScreenDestination"

@Composable
fun MobiusPopUpDialogPresentation() {
    val iconVisible = remember { mutableStateOf(true) }
    val titleVisible = remember { mutableStateOf(true) }
    val contentVisible = remember { mutableStateOf(true) }
    val buttonsVisible = remember { mutableStateOf(true) }
    val showPopupDialog = remember { mutableStateOf(false) }
    val scrollPolicy = remember { mutableStateOf(ScrollPolicy.ScrollContentOnly) }
    val buttonsLayout = remember { mutableStateOf(HORIZONTAL_FLOW) }
    val buttonsWidth = remember { mutableStateOf<ButtonWidth>(ButtonsWidthPresets.Default) }
    val buttonsAlignment = remember { mutableStateOf(Alignment.End) }

    Mobius {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = popUpPresentationMenuDestination
        ) {
            composable(popUpPresentationMenuDestination) {
                PopUpPresentationMenu(
                    onNavigateToPopUpScreen = {
                        navController.navigate(popUpScreenDestination)
                    },
                    onShowPopupDialog = {
                        showPopupDialog.value = true
                    },
                    iconVisible = iconVisible,
                    titleVisible = titleVisible,
                    contentVisible = contentVisible,
                    buttonsVisible = buttonsVisible,
                    scrollPolicy = scrollPolicy,
                    buttonsArrangement = buttonsLayout,
                    buttonsAlignment = buttonsAlignment,
                    buttonsWidth = buttonsWidth
                )
            }

            dialog(popUpScreenDestination) {
                PopUpScreen(
                    onDismissRequest = { navController.popBackStack() },
                    iconVisible = iconVisible.value,
                    titleVisible = titleVisible.value,
                    contentVisible = contentVisible.value,
                    buttonsVisible = buttonsVisible.value,
                    scrollPolicy = scrollPolicy.value,
                    buttonsLayout = buttonsLayout.value,
                    buttonsAlignment = buttonsAlignment.value,
                    buttonsWidth = buttonsWidth.value
                )
            }
        }

        if (showPopupDialog.value) {
            Dialog(
                onDismissRequest = { showPopupDialog.value = false }
            ) {
                PopUpScreen(
                    onDismissRequest = { showPopupDialog.value = false },
                    iconVisible = iconVisible.value,
                    titleVisible = titleVisible.value,
                    contentVisible = contentVisible.value,
                    buttonsVisible = buttonsVisible.value,
                    scrollPolicy = scrollPolicy.value,
                    buttonsLayout = buttonsLayout.value,
                    buttonsAlignment = buttonsAlignment.value,
                    buttonsWidth = buttonsWidth.value
                )
            }
        }
    }
}

@Composable
private fun PopUpPresentationMenu(
    onNavigateToPopUpScreen: () -> Unit,
    onShowPopupDialog: () -> Unit,
    iconVisible: MutableState<Boolean>,
    titleVisible: MutableState<Boolean>,
    contentVisible: MutableState<Boolean>,
    buttonsVisible: MutableState<Boolean>,
    scrollPolicy: MutableState<ScrollPolicy>,
    buttonsArrangement: MutableState<ButtonsLayoutOptions>,
    buttonsAlignment: MutableState<Alignment.Horizontal>,
    buttonsWidth: MutableState<ButtonWidth>,
) {
    Screen {
        Content {
            Row {
                Option(label = "Icon visible:") {
                    Checkbox(checked = iconVisible.value, onCheckedChange = { iconVisible.value = it })
                }
                LargeElementSpacer()
                Option(label = "Title visible:") {
                    Checkbox(checked = titleVisible.value, onCheckedChange = { titleVisible.value = it })
                }
            }
            Row {
                Option(label = "Content visible:") {
                    Checkbox(checked = contentVisible.value, onCheckedChange = { contentVisible.value = it })
                }
                LargeElementSpacer()
                Option(label = "Buttons visible:") {
                    Checkbox(checked = buttonsVisible.value, onCheckedChange = { buttonsVisible.value = it })
                }
            }
            Option(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Mobius.colors.surfaceContainerHigh)
                    .padding(8.dp),
                label = "Buttons arrangement:"
            ) {
                RadioButtonWithLabel(
                    label = "Flow",
                    selected = buttonsArrangement.value == HORIZONTAL_FLOW,
                    onClick = { buttonsArrangement.value = HORIZONTAL_FLOW }
                )
                RadioButtonWithLabel(
                    label = "Column",
                    selected = buttonsArrangement.value == COLUMN,
                    onClick = { buttonsArrangement.value = COLUMN }
                )
            }
            ElementSpacer()
            Option(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Mobius.colors.surfaceContainerHigh)
                    .padding(8.dp),
                label = "Buttons alignment:"
            ) {
                Column {
                    RadioButtonWithLabel(
                        label = "Start",
                        selected = buttonsAlignment.value == Alignment.Start,
                        onClick = { buttonsAlignment.value = Alignment.Start }
                    )
                    RadioButtonWithLabel(
                        label = "Center",
                        selected = buttonsAlignment.value == Alignment.CenterHorizontally,
                        onClick = { buttonsAlignment.value = Alignment.CenterHorizontally }
                    )
                    RadioButtonWithLabel(
                        label = "End",
                        selected = buttonsAlignment.value == Alignment.End,
                        onClick = { buttonsAlignment.value = Alignment.End }
                    )
                }
            }
            ElementSpacer()
            Option(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Mobius.colors.surfaceContainerHigh)
                    .padding(8.dp),
                label = "Scroll policy:"
            ) {
                Column {
                    RadioButtonWithLabel(
                        label = "No scroll",
                        selected = scrollPolicy.value == ScrollPolicy.NoScroll,
                        onClick = { scrollPolicy.value = ScrollPolicy.NoScroll }
                    )
                    RadioButtonWithLabel(
                        label = "Scroll content only",
                        selected = scrollPolicy.value == ScrollPolicy.ScrollContentOnly,
                        onClick = { scrollPolicy.value = ScrollPolicy.ScrollContentOnly }
                    )
                    RadioButtonWithLabel(
                        label = "Scroll everything",
                        selected = scrollPolicy.value == ScrollPolicy.ScrollEverything,
                        onClick = { scrollPolicy.value = ScrollPolicy.ScrollEverything }
                    )
                }
            }
            ElementSpacer()
            Option(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Mobius.colors.surfaceContainerHigh)
                    .padding(8.dp)
                    .modifyIf(buttonsArrangement.value != COLUMN) {
                        alpha(0.2f).clickable(false) {}
                    },
                label = "Buttons width:"
            ) {
                Column {
                    RadioButtonWithLabel(
                        label = "Default",
                        selected = buttonsWidth.value == ButtonsWidthPresets.Default,
                        onClick = { buttonsWidth.value = ButtonsWidthPresets.Default }
                    )
                    RadioButtonWithLabel(
                        label = "Fixed",
                        selected = buttonsWidth.value == ButtonsWidthPresets.Fixed,
                        onClick = { buttonsWidth.value = ButtonsWidthPresets.Fixed }
                    )
                    RadioButtonWithLabel(
                        label = "Max",
                        selected = buttonsWidth.value == ButtonsWidthPresets.Max,
                        onClick = { buttonsWidth.value = ButtonsWidthPresets.Max }
                    )
                    RadioButtonWithLabel(
                        label = "Match other buttons",
                        selected = buttonsWidth.value == ButtonsWidthPresets.MatchOtherButtons,
                        onClick = { buttonsWidth.value = ButtonsWidthPresets.MatchOtherButtons }
                    )
                }

            }
            LargeElementSpacer()
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(IntrinsicSize.Max)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onNavigateToPopUpScreen
                ) {
                    Text(text = "Navigate to pop-up screen")
                }
                ElementSpacer()
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onShowPopupDialog
                ) {
                    Text(text = "Show pop-up dialog")
                }
            }
        }
    }
}

@Composable
private fun Option(
    modifier: Modifier = Modifier,
    label: String,
    content: @Composable () -> Unit,
) {
    Label(
        modifier = modifier,
        text = {
            Text(
                modifier = Modifier.width(110.dp),
                text = label
            )
        },
        labelPlacement = LabelPlacement.Start.CenterVertically,
        content = content
    )
}

@Composable
private fun RadioButtonWithLabel(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Label(
        text = { Text(label) },
        labelPlacement = LabelPlacement.End.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier.height(40.dp),
            selected = selected,
            onClick = onClick
        )
    }
}

@Composable
private fun PopUpScreen(
    onDismissRequest: () -> Unit,
    iconVisible: Boolean,
    titleVisible: Boolean,
    contentVisible: Boolean,
    buttonsVisible: Boolean,
    scrollPolicy: ScrollPolicy,
    buttonsLayout: ButtonsLayoutOptions,
    buttonsAlignment: Alignment.Horizontal,
    buttonsWidth: ButtonWidth,
) {
    val popUpScreenStyle = object : PopUpScreenStyle by Mobius.styles.popUpScreenStyle {
        override val buttonsStyle: Token<DialogButtonsStyle> = Token {
            object : DialogButtonsStyle by Mobius.styles.dialogButtonsStyle {
                override val buttonsLayout: Token<ButtonsLayout> = Token {
                    when (buttonsLayout) {
                        COLUMN -> ButtonsLayout.Column(
                            horizontalAlignment = buttonsAlignment,
                            buttonWidth = buttonsWidth
                        )

                        HORIZONTAL_FLOW -> ButtonsLayout.HorizontalFlow(
                            horizontalAlignment = buttonsAlignment
                        )
                    }
                }
            }
        }
    }

    PopUpScreen(
        modifier = Modifier
            .heightIn(0.dp, 400.dp),
        scrollPolicy = scrollPolicy,
        icon = if (iconVisible) {
            {
                Icon(drawableResId = R.drawable.ic_account, contentDescription = "")
            }
        } else null,
        title = if (titleVisible) {
            {
                Text("Pop-up title")
            }
        } else null,
        content = if (contentVisible) {
            {
                Text(
                    modifier = Modifier.width(200.dp),
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            }
        } else null,
        buttons = if (buttonsVisible) {
            {
                if (buttonsLayout == COLUMN) {
                    Button(onClick = onDismissRequest) {
                        Text(text = "Ok")
                    }
                    Button(onClick = onDismissRequest) {
                        Text(text = "Cancel")
                    }
                } else {
                    TextButton(onClick = onDismissRequest) {
                        Text(text = "Ok")
                    }
                    TextButton(onClick = onDismissRequest) {
                        Text(text = "Cancel")
                    }
                }

            }
        } else null,
        style = popUpScreenStyle
    )
}

private enum class ButtonsLayoutOptions {
    COLUMN, HORIZONTAL_FLOW
}

private object ButtonsWidthPresets {
    val Fixed = ButtonWidth.Fixed(160.dp)
    val Default = ButtonWidth.Default
    val Max = ButtonWidth.Max
    val MatchOtherButtons = ButtonWidth.MatchOtherButtons
}
