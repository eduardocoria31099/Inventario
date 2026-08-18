/*
 * EmptyState.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.components.empty_state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.software.inventario.components.text.TextNormalBold
import com.software.inventario.components.text.TextSmall
import com.kmp.core.design.dimen.Dimens
import com.software.inventario.components.button.ButtonPrimary
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.example
import inventario.sharedui.generated.resources.ic_example
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyState(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    titleTextColor: Color,
    titleText: String,
    descriptionTextColor: Color,
    descriptionText: String,
    buttonBackgroundColor: Color,
    buttonTextColor: Color,
    buttonText: String? = null,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = Dimens.padding32),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(Dimens.height64),
            painter = painterResource(image),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextNormalBold(
            modifier = Modifier.fillMaxWidth(),
            color = titleTextColor,
            text = titleText,
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextSmall(
            modifier = Modifier.fillMaxWidth(),
            color = descriptionTextColor,
            text = descriptionText,
        )
        if (buttonText != null) {
            Spacer(modifier = Modifier.height(Dimens.height32))
            ButtonPrimary(
                backgroundColor = buttonBackgroundColor,
                textColors = buttonTextColor,
                text = buttonText,
                onClick = onButtonClick,
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun EmptyStatePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Dimens.padding16),
        verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
    ) {
        EmptyState(
            image = Res.drawable.ic_example,
            titleTextColor = Color.Black,
            titleText = stringResource(Res.string.example),
            descriptionTextColor = Color.Black,
            descriptionText = stringResource(Res.string.example),
            buttonBackgroundColor = Color.Black,
            buttonTextColor = Color.White,
            buttonText = stringResource(Res.string.example),
        )
    }
}
