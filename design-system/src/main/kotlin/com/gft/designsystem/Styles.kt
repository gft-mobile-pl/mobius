package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.WeakHashMap
import java.util.concurrent.atomic.AtomicReference

@Stable
interface StyleValues

@Stable
interface Style

interface DynamicStyle : Style

@PublishedApi
internal class StylesCache : MutableMap<Any, Any> by WeakHashMap()

@PublishedApi
internal val LocalStylesCache = staticCompositionLocalOf { StylesCache() }

@Composable
inline fun <reified T : StyleValues, R : Style> R.produceStyleValues(
    noinline styleProducer: @Composable (R) -> T,
): T {
    return if (this is DynamicStyle) {
        val localStyleCache = remember(this) {
            mutableStateOf<T?>(null)
        }
        UpdateLocalStyleCache(localStyleCache) { styleProducer(this) }
        localStyleCache.value!!
    } else {
        val cache = LocalStylesCache.current
        synchronized(cache) {
            val cachedStyle = cache[this]
            if (cachedStyle != null && cachedStyle is T) {
                cachedStyle
            } else {
                val newStyle = styleProducer(this)
                cache[this] = newStyle
                newStyle
            }
        }
    }
}

@PublishedApi
@Composable
internal fun <T : StyleValues> UpdateLocalStyleCache(
    localStyleCache: MutableState<T?>,
    styleProducer: @Composable () -> T,
) {
    localStyleCache.value = styleProducer()
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
