package com.gft.mobius.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import com.gft.mobius.components.SwipeToDismissBox
import com.gft.mobius.components.SwipeToDismissBoxState.Visible
import com.gft.mobius.components.Text
import com.gft.mobius.components.rememberSwipeToDismissBoxController

@Composable
internal fun MobiusSwipeToDismissBoxPresentation(
    onBack: () -> Unit,
) {
    Screen {
        MobiusPresentationNavigationBar(
                title = "Swipe to dismiss",
                onBack = onBack,
            )
        Content(
            isScrollable = false
        ) {
            val items = remember { (1..10).toList().toMutableStateList() }
            LazyColumn {
                items(
                    items = items,
                    key = { it }
                ) { item ->
                    DismissibleItem(
                        item = item,
                        onDismissed = { items.remove(item) }
                    )
                }
            }
        }
    }
}

@Composable
private fun DismissibleItem(
    item: Int,
    onDismissed: () -> Unit,
) {
    val controller = rememberSwipeToDismissBoxController(
        initialState = Visible,
        swipeThreshold = { totalDistance -> totalDistance / 2 }
    )
    SwipeToDismissBox(
        controller = controller,
        allowSwipeToStart = true,
        allowSwipeToEnd = true,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Mobius.colors.error)
            )
        },
        onDismissed = { onDismissed() }
    ) {
        Box(
            Modifier
                .background(Mobius.colors.secondaryContainer)
                .fillMaxWidth()
                .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Swipe to dismiss item $item"
            )
        }
    }
}
