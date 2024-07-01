package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import kotlin.reflect.KProperty

@Stable
sealed interface Token<T> {

    @Composable
    fun resolve(): T
}

interface TokenReference<T> : Token<T> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): TokenReference<T> = this
}

@Stable
internal class ValueToken<T>(
    private val value: T,
) : Token<T> {

    @Composable
    @ReadOnlyComposable
    @Stable
    override fun resolve(): T = value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValueToken<*>

        return value == other.value
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}

@Stable
internal class ReferenceToValue<T>(
    private val valueResolver: @Composable () -> T,
) : TokenReference<T> {

    @Composable
    override fun resolve(): T = valueResolver.invoke()
}

@Stable
fun <T> Token(value: T): Token<T> = ValueToken(value)

@Stable
fun <T> Token(valueResolver: @Composable () -> T): Token<T> = ReferenceToValue(valueResolver)

@Stable
fun <T> tokenReference(tokenProvider: @Composable () -> Token<T>): TokenReference<T> = ReferenceToValue { tokenProvider().resolve() }
