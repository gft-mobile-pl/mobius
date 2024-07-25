package com.gft.designsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gft.mobius.Mobius
import com.gft.mobius.components.Icon
import com.gft.mobius.components.LeadingIconTab
import com.gft.mobius.components.PrimaryScrollableTabRow
import com.gft.mobius.components.PrimaryTabRow
import com.gft.mobius.components.SecondaryScrollableTabRow
import com.gft.mobius.components.SecondaryTabRow
import com.gft.mobius.components.Tab
import com.gft.mobius.components.Text


@Composable
fun MobiusTabsPresentation() {
    Mobius {
        var selectedTab by remember {
            mutableIntStateOf(0)
        }

        Column {
            PrimaryTabRow(
                selectedTabIndex = selectedTab,
            ) {
                LeadingIconTab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(drawableResId = android.R.drawable.ic_delete, contentDescription = "")
                    },
                    text = { Text(text = "Zero") }
                )

                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(drawableResId = android.R.drawable.ic_delete, contentDescription = "")
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

        }
    }
}