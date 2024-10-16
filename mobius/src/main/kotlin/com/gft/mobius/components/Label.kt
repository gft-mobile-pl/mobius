package com.gft.mobius.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.LabelAxis.Horizontal
import com.gft.mobius.components.LabelAxis.Vertical
import com.gft.mobius.components.LabelPlacement.End
import com.gft.mobius.components.styles.LabelStyle
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Label(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    style: LabelStyle = Mobius.styles.labelStyle,
    labelPlacement: LabelPlacement = End.CenterVertically,
    onClick: () -> Unit,
    content: @Composable ClickableLabelScope.() -> Unit
) {
    Label(
        modifier = Modifier
            .clickable(onClick = onClick)
            .minimumInteractiveComponentSize()
            .then(modifier),
        text = text,
        style = style,
        labelPlacement = labelPlacement,
        content = { ClickableLabelScope.content() }
    )
}

@Composable
fun Label(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    style: LabelStyle = Mobius.styles.labelStyle,
    labelPlacement: LabelPlacement = End.CenterVertically,
    content: @Composable () -> Unit
) {
    val styleValues = style.resolve()

    val styledText = @Composable {
        ProvideTextStyle(styleValues.textStyle) {
            text()
        }
    }

    val orderedContent = @Composable {
        if (labelPlacement.isBeforeContent()) {
            styledText()
            Spacer(modifier = Modifier.size(styleValues.spacing))
            content()
        } else {
            content()
            Spacer(modifier = Modifier.size(styleValues.spacing))
            styledText()
        }
    }

    when (labelPlacement) {
        is Horizontal -> Row(
            modifier = modifier,
            verticalAlignment = labelPlacement.alignment
        ) {
            orderedContent()
        }

        is Vertical -> Column(
            modifier = modifier,
            horizontalAlignment = labelPlacement.alignment
        ) {
            orderedContent()
        }
    }
}

private fun LabelPlacement.isBeforeContent() = this is LabelPlacement.Start || this is LabelPlacement.Top

sealed interface LabelPlacement {
    sealed class Start(alignment: Alignment.Vertical) : Horizontal(alignment), LabelPlacement {
        data object AlignTop : Start(Alignment.Top)
        data object CenterVertically : Start(Alignment.CenterVertically)
        data object AlignBottom : Start(Alignment.Bottom)
    }

    sealed class End(alignment: Alignment.Vertical) : Horizontal(alignment), LabelPlacement {
        data object AlignTop : End(Alignment.Top)
        data object CenterVertically : End(Alignment.CenterVertically)
        data object AlignBottom : End(Alignment.Bottom)
    }

    sealed class Top(alignment: Alignment.Horizontal) : Vertical(alignment), LabelPlacement {
        data object AlignStart : Top(Alignment.Start)
        data object CenterHorizontally : Top(Alignment.CenterHorizontally)
        data object AlignEnd : Top(Alignment.End)
    }

    sealed class Bottom(alignment: Alignment.Horizontal) : Vertical(alignment), LabelPlacement {
        data object AlignStart : Top(Alignment.Start)
        data object CenterHorizontally : Top(Alignment.CenterHorizontally)
        data object AlignEnd : Top(Alignment.End)
    }
}

sealed interface LabelAxis {
    sealed class Horizontal(val alignment: Alignment.Vertical)
    sealed class Vertical(val alignment: Alignment.Horizontal)
}

interface ClickableLabelScope {
    companion object : ClickableLabelScope
}
