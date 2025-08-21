package com.gft.mobius.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.HorizontalDivider
import com.gft.mobius.components.Icon
import com.gft.mobius.components.LeadingIconTab
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.PrimaryScrollableTabRow
import com.gft.mobius.components.PrimaryTabRow
import com.gft.mobius.components.SecondaryScrollableTabRow
import com.gft.mobius.components.SecondaryTabRow
import com.gft.mobius.components.Tab
import com.gft.mobius.components.TabRow
import com.gft.mobius.components.Text
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_delete

@Composable
internal fun MobiusTabsPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        var selectedTab by remember {
            mutableIntStateOf(0)
        }

        Column {
            MobiusPresentationNavigationBar(
                title = "Tab",
                onBack = onBack,
            )
            PrimaryTabRow(
                selectedTabIndex = selectedTab,
            ) {
                LeadingIconTab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(drawableResource = Res.drawable.ic_delete, contentDescription = "")
                    },
                    text = { Text(text = "Zero") }
                )

                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(drawableResource = Res.drawable.ic_delete, contentDescription = "")
                    },
                    text = { Text(text = "1") }
                )

                Tab(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    text = { Text(text = "Two") }
                )

                Tab(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    text = { Text(text = "3 (Three)") }
                )
            }
            SecondaryTabRow(
                selectedTabIndex = selectedTab,
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text(text = "Zero") }
                )

                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text(text = "1") }
                )

                Tab(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    text = { Text(text = "Two") }
                )

                Tab(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    text = { Text(text = "3 (Three)") }
                )
            }

            var selectedScrollableTab by remember {
                mutableIntStateOf(0)
            }
            PrimaryScrollableTabRow(
                selectedTabIndex = selectedScrollableTab
            ) {
                Tab(
                    selected = selectedScrollableTab == 0,
                    onClick = { selectedScrollableTab = 0 },
                    text = { Text(text = "Zero") }
                )

                Tab(
                    selected = selectedScrollableTab == 1,
                    onClick = { selectedScrollableTab = 1 },
                    text = { Text(text = "1") }
                )

                Tab(
                    selected = selectedScrollableTab == 2,
                    onClick = { selectedScrollableTab = 2 },
                    text = { Text(text = "Two") }
                )

                Tab(
                    selected = selectedScrollableTab == 3,
                    onClick = { selectedScrollableTab = 3 },
                    text = { Text(text = "3 (Three)") }
                )

                Tab(
                    selected = selectedScrollableTab == 4,
                    onClick = { selectedScrollableTab = 4 },
                    text = { Text(text = "Four") }
                )

                Tab(
                    selected = selectedScrollableTab == 5,
                    onClick = { selectedScrollableTab = 5 },
                    text = { Text(text = "Five") }
                )

                Tab(
                    selected = selectedScrollableTab == 6,
                    onClick = { selectedScrollableTab = 6 },
                    text = { Text(text = "Six") }
                )
            }

            SecondaryScrollableTabRow(
                selectedTabIndex = selectedScrollableTab
            ) {
                Tab(
                    selected = selectedScrollableTab == 0,
                    onClick = { selectedScrollableTab = 0 },
                    text = { Text(text = "Zero") }
                )

                Tab(
                    selected = selectedScrollableTab == 1,
                    onClick = { selectedScrollableTab = 1 },
                    text = { Text(text = "1") }
                )

                Tab(
                    selected = selectedScrollableTab == 2,
                    onClick = { selectedScrollableTab = 2 },
                    text = { Text(text = "Two") }
                )

                Tab(
                    selected = selectedScrollableTab == 3,
                    onClick = { selectedScrollableTab = 3 },
                    text = { Text(text = "3 (Three)") }
                )

                Tab(
                    selected = selectedScrollableTab == 4,
                    onClick = { selectedScrollableTab = 4 },
                    text = { Text(text = "Four") }
                )

                Tab(
                    selected = selectedScrollableTab == 5,
                    onClick = { selectedScrollableTab = 5 },
                    text = { Text(text = "Five") }
                )

                Tab(
                    selected = selectedScrollableTab == 6,
                    onClick = { selectedScrollableTab = 6 },
                    text = { Text(text = "Six") }
                )
            }

            var selectedNoIndicatorTab by remember {
                mutableIntStateOf(0)
            }
            TabRow(
                selectedTabIndex = selectedNoIndicatorTab,
                containerColor = Mobius.colors.surface,
                tabIndicator = { selectedTabIndex, tabBounds ->
                    Spacer(
                        Modifier
                            .tabIndicatorOffset(tabBounds[selectedTabIndex])
                            .height(4.dp)
                            .matchContentSize(tabBounds[selectedTabIndex])
                            .background(Color.Red)
                    )
                },
                divider = { HorizontalDivider() }
            ) {
                Tab(
                    selected = selectedNoIndicatorTab == 0,
                    onClick = { selectedNoIndicatorTab = 0 },
                    text = { Text(text = "One") }
                )
                Tab(
                    selected = selectedNoIndicatorTab == 1,
                    onClick = { selectedNoIndicatorTab = 1 },
                    text = { Text(text = "Two") }
                )
            }
        }
    }
}
