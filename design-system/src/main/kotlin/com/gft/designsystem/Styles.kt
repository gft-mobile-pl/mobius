package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.WeakHashMap
import java.util.concurrent.atomic.AtomicReference

@Stable
interface StyleValues

@Stable
interface Style

@PublishedApi
internal class StylesCache : MutableMap<Any, Any> by WeakHashMap()

@PublishedApi
internal val LocalStylesCache = staticCompositionLocalOf { StylesCache() }

@Composable
inline fun <reified T : StyleValues> Style.produceStyle(
    styleProducer: @Composable () -> T,
): T {
    val cache = LocalStylesCache.current
    return synchronized(cache) {
        val cachedStyle = cache[this]
        if (cachedStyle != null && cachedStyle is T) {
            cachedStyle
        } else {
            val newStyle = styleProducer()
            cache[this] = newStyle
            newStyle
        }
    }
}

@Composable
fun <T : Style> rememberStyle(
    vararg keys: Any?,
    styleProducer: @Composable () -> T
): T {
    val styleReference = remember(*keys) {
        AtomicReference<T?>(null)
    }
    return styleReference.get() ?: synchronized(styleReference) {
        styleReference.get() ?: styleProducer().apply { styleReference.set(this) }
    }
}