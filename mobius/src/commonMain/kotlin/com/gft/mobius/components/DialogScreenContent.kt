package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.NEGLIGIBLE_NON_ZERO_WEIGHT
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.components.styles.resolve

open class DialogScreenContentScope(contentStyle: ContentStyleValues, columnScope: ColumnScope) :
    ContentScope(contentStyle), ColumnScope by columnScope

@Composable
fun DialogScreenScope.Content(
    modifier: Modifier = Modifier,
    isScrollable: Boolean = true,
    style: ContentStyle = if (isScrollable) Mobius.styles.dialogScrollableContentStyle else Mobius.styles.dialogContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = Modifier
        .fillDialogWidth()
        .then(modifier),
    scrollState = if (isScrollable) rememberScrollState() else null,
    styleValues = style.resolve(),
    content = content
)

@Composable
fun DialogScreenScope.Content(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    style: ContentStyle = Mobius.styles.dialogScrollableContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = Modifier
        .fillDialogWidth()
        .then(modifier),
    scrollState = scrollState,
    styleValues = style.resolve(),
    content = content
)

@Composable
internal fun DialogScreenScope.Content(
    modifier: Modifier = Modifier,
    scrollState: ScrollState?,
    styleValues: ContentStyleValues,
    content: @Composable DialogScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = Modifier
        .fillDialogWidth()
        .then(modifier),
    scrollState = scrollState,
    styleValues = styleValues,
    content = content
)

@Composable
private fun ColumnScope.ContentImplementation(
    modifier: Modifier,
    scrollState: ScrollState?,
    styleValues: ContentStyleValues,
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    ContentBuilder(
        modifier = modifier,
        scrollState = scrollState,
        styleValues = styleValues,
    ) { contentModifier ->
        Column(
            modifier = Modifier
                .weight(weight = NEGLIGIBLE_NON_ZERO_WEIGHT, fill = false)
                .then(contentModifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment()
        ) {
            DialogScreenContentScope(contentStyle = styleValues, columnScope = this).content()
        }
    }
}
