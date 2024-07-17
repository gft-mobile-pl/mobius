package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Text
import com.gft.mobius.components.styles.ProvideTextStyle

@Composable
internal fun MobiusTypographyPresentation() {
    Mobius {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            ) {
                Text(
                    text = "Default Text"
                )
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            ) {
                ProvideTextStyle(
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontSize = 24.sp
                    )
                ) {
                    Text(
                        text = "Overridden Text Style"
                    )
                }

            }

            TextItem(
                text = "Display Large",
                style = Mobius.typography.displayLarge,
                backgroundColor = Color(0xffeeeeee),
            )
            TextItem(
                text = "Display Medium",
                style = Mobius.typography.displayMedium,
                backgroundColor = Color(0xffdddddd),
            )
            TextItem(
                text = "Display Small",
                style = Mobius.typography.displaySmall,
                backgroundColor = Color(0xffcccccc),
            )

            TextItem(
                text = "Headline Large",
                style = Mobius.typography.headlineLarge,
                backgroundColor = Color(0xffeeeeee),
            )
            TextItem(
                text = "Headline Medium",
                style = Mobius.typography.headlineMedium,
                backgroundColor = Color(0xffdddddd),
            )
            TextItem(
                text = "Headline Small",
                style = Mobius.typography.headlineSmall,
                backgroundColor = Color(0xffcccccc),
            )

            TextItem(
                text = "Title Large",
                style = Mobius.typography.titleLarge,
                backgroundColor = Color(0xffeeeeee),
            )
            TextItem(
                text = "Title Medium",
                style = Mobius.typography.titleMedium,
                backgroundColor = Color(0xffdddddd),
            )
            TextItem(
                text = "Title Small",
                style = Mobius.typography.titleSmall,
                backgroundColor = Color(0xffcccccc),
            )

            TextItem(
                text = "Label Large",
                style = Mobius.typography.labelLarge,
                backgroundColor = Color(0xffeeeeee),
            )
            TextItem(
                text = "Label Medium",
                style = Mobius.typography.labelMedium,
                backgroundColor = Color(0xffdddddd),
            )
            TextItem(
                text = "Label Small",
                style = Mobius.typography.labelSmall,
                backgroundColor = Color(0xffcccccc),
            )

            TextItem(
                text = "Body Large$LoremIpsum",
                style = Mobius.typography.bodyLarge,
                backgroundColor = Color(0xffeeeeee),
            )
            TextItem(
                text = "Body Medium$LoremIpsum",
                style = Mobius.typography.bodyMedium,
                backgroundColor = Color(0xffdddddd),
            )
            TextItem(
                text = "Body Small$LoremIpsum",
                style = Mobius.typography.bodySmall,
                backgroundColor = Color(0xffcccccc),
            )
        }
    }
}

@Composable
private fun TextItem(
    text: String,
    style: TextStyle,
    backgroundColor: Color
) {
    Text(
        modifier = Modifier
            .background(backgroundColor)
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        text = text,
        style = style,
    )
}

private const val LoremIpsum =
    "\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."