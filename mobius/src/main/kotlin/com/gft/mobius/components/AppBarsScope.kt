@file:OptIn(ExperimentalComposeUiApi::class)

package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.unit.Velocity

internal val LocalTopAppBarScrollContext = modifierLocalOf<ScrollContext<TopAppBar.ScrollConfig>?> { null }
internal val LocalBottomAppBarScrollContext = modifierLocalOf<ScrollContext<BottomAppBar.ScrollConfig>?> { null }

@Composable
fun AppBarsScope(
    modifier: Modifier = Modifier,
    topAppBarScrollConfig: TopAppBar.ScrollConfig = TopAppBar.scrollConfig(),
    bottomAppBarScrollConfig: BottomAppBar.ScrollConfig = BottomAppBar.scrollConfig(),
    content: @Composable () -> Unit,
) {
    Box(modifier.appBarsScope(topAppBarScrollConfig, bottomAppBarScrollConfig)) {
        content()
    }
}

@Composable
fun Modifier.appBarsScope(
    topAppBarScrollConfig: TopAppBar.ScrollConfig = TopAppBar.scrollConfig(),
    bottomAppBarScrollConfig: BottomAppBar.ScrollConfig = BottomAppBar.scrollConfig(),
): Modifier {
    val appBarNestedScrollConnection = remember { AppBarsNestedScrollConnection() }
    return this
        .modifierLocalProvider(LocalTopAppBarScrollContext) { ScrollContext(topAppBarScrollConfig, appBarNestedScrollConnection) }
        .modifierLocalProvider(LocalBottomAppBarScrollContext) { ScrollContext(bottomAppBarScrollConfig, appBarNestedScrollConnection) }
        .nestedScroll(appBarNestedScrollConnection)
}

internal data class ScrollContext<T> (
    val scrollConfig: T,
    val appBarsNestedScrollConnection: AppBarsNestedScrollConnection
)

internal class AppBarsNestedScrollConnection : NestedScrollConnection {
    private val connections: MutableList<NestedScrollConnection> = mutableListOf()

    fun registerNestedScrollConnection(connection: NestedScrollConnection) {
        connections.add(connection)
    }

    fun unregisterNestedScrollConnection(connection: NestedScrollConnection) {
        connections.remove(connection)
    }

    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset =
        connections.sumOfOffsets { connection -> connection.onPreScroll(available, source) }

    override fun onPostScroll(consumed: Offset, available: Offset, source: NestedScrollSource): Offset =
        connections.sumOfOffsets { connection -> connection.onPostScroll(consumed, available, source) }

    override suspend fun onPreFling(available: Velocity): Velocity =
        connections.sumOfVelocities { connection -> connection.onPreFling(available) }

    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity =
        connections.sumOfVelocities { connection -> connection.onPostFling(consumed, available) }

    private inline fun <T> Iterable<T>.sumOfOffsets(selector: (T) -> Offset): Offset =
        fold(Offset.Zero) { sum, connection -> sum + selector(connection) }

    private inline fun <T> Iterable<T>.sumOfVelocities(selector: (T) -> Velocity): Velocity =
        fold(Velocity.Zero) { sum, connection -> sum + selector(connection) }
}
