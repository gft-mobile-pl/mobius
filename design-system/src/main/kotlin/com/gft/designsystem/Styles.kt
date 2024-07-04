package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.concurrent.ConcurrentHashMap

@Stable
interface StyleValues

@Stable
interface Style

interface DynamicStyle

@PublishedApi
internal class StylesCache : MutableMap<Class<*>, Any> by ConcurrentHashMap()

@PublishedApi
internal val LocalStylesCache = staticCompositionLocalOf { StylesCache() }

@Composable
inline fun <reified T : StyleValues> Style.produceStyle(
    useCache: Boolean = true,
    styleProducer: @Composable () -> T,
): T {
    return if (useCache && this !is DynamicStyle) {
        val cache = LocalStylesCache.current
        val cachedStyle = cache[this::class.java]
        if (cachedStyle != null && cachedStyle is T) {
            cachedStyle
        } else {
            val newStyle = styleProducer()
            cache[this::class.java] = newStyle
            newStyle
        }
    } else {
        styleProducer()
    }
}
