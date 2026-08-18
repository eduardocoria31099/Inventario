/*
 * Card.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.software.inventario.components.text.TextNormalBold
import com.software.inventario.components.text.TextSmall
import com.kmp.core.design.dimen.Dimens
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.example
import org.jetbrains.compose.resources.stringResource

@Composable
fun SimpleCard(
    modifier: Modifier = Modifier,
    titleTextColor: Color,
    titleText: String,
    subtitleTextColor: Color,
    subtitleText: String,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.elevation2),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(
            modifier = Modifier.padding(all = Dimens.padding16)) {
            TextNormalBold(
                modifier = Modifier.fillMaxWidth(),
                color = titleTextColor,
                text = titleText,
            )
            Spacer(modifier = Modifier.height(Dimens.height16))
            TextSmall(
                modifier = Modifier.fillMaxWidth(),
                color = subtitleTextColor,
                text = subtitleText,
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun SimpleCardCustomPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
    ) {
        SimpleCard(
            titleTextColor = Color.Black,
            titleText = stringResource(Res.string.example),
            subtitleTextColor = Color.Black,
            subtitleText = stringResource(Res.string.example),
        )
    }
}
