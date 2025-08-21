package com.gft.mobius.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Token
import com.gft.designsystem.rememberStyle
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.DefaultTopAppBarStyle
import com.gft.mobius.components.styles.TopAppBarStyle
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_back
import org.jetbrains.compose.resources.painterResource

@Composable
internal expect fun MobiusPresentationNavigationBar(
    title: String = "",
    onBack: () -> Unit,
)

@Composable
internal fun MobiusPresentationNavigationBarContent(
    title: String,
    onBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            IconButton(
                onClick = onBack,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_back),
                        contentDescription = null,
                        tint = Mobius.colors.onPrimary,
                    )
                },
            )
        },
        style = mobiusPresentationNavigationBarStyle()
    )
}

@Composable
fun mobiusPresentationNavigationBarStyle() = rememberStyle(Mobius.styles.topAppBarStyle) {
    object : TopAppBarStyle by Mobius.styles.topAppBarStyle {
        override val backgroundColor: Token<Color> = Token { Mobius.colors.primary }
        override val titleContentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    }
}
