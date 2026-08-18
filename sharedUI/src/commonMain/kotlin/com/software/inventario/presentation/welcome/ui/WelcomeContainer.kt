/*
 * HeatContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.presentation.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.kmp.core.design.dimen.Dimens
import com.kommon.versions.KommonVersions
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import com.software.inventario.components.button.ButtonPrimary
import com.software.inventario.components.container.SafeScreenContainerTest
import com.software.inventario.components.text.TextBigBold
import com.software.inventario.components.text.TextMedium
import com.software.inventario.theme.AppTheme
import com.software.inventario.utils.enums.BuildTypes
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.explore_our_multiplatform_platform
import inventario.sharedui.generated.resources.hello
import inventario.sharedui.generated.resources.il_placeholder
import inventario.sharedui.generated.resources.image
import inventario.sharedui.generated.resources.next
import inventario.sharedui.generated.resources.version_app
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeContainer(
    onNavigateToLogin: () -> Unit = {},
    showDialogInfo: () -> Unit = {},
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding16)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(
            space = Dimens.padding16,
            alignment = Alignment.CenterVertically,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(Dimens.height16))
        CoilImage(
            modifier = Modifier
                .size(size = Dimens.height96)
                .clip(shape = RoundedCornerShape(size = Dimens.height12)),
            imageModel = { "https://miro.medium.com/1*DH2pe-b0-898YDap6ReV8Q.png" },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            ),
            loading = {
                CircularProgressIndicator(modifier = Modifier.size(Dimens.height96))
            },
            failure = {
                Image(
                    painter = painterResource(Res.drawable.il_placeholder),
                    contentDescription = stringResource(Res.string.image),
                )
            },
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        TextBigBold(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.hello),
        )
        Spacer(modifier = Modifier.height(Dimens.padding16))
        TextMedium(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.black,
            text = stringResource(Res.string.explore_our_multiplatform_platform),
        )
        Spacer(modifier = Modifier.height(Dimens.height16))
        ButtonPrimary(
            modifier = Modifier.padding(start = Dimens.padding16, end = Dimens.padding16),
            backgroundColor = AppTheme.colors.primary,
            textColors = AppTheme.colors.text.white,
            text = Res.string.next,
            onClick = onNavigateToLogin,
        )
        if (KommonVersions.BUILD_TYPE == BuildTypes.DEBUG) {
            ButtonPrimary(
                modifier = Modifier.padding(start = Dimens.padding16, end = Dimens.padding16),
                backgroundColor = AppTheme.colors.primary,
                textColors = AppTheme.colors.text.white,
                text = Res.string.version_app,
                onClick = showDialogInfo,
            )
        }
        Spacer(modifier = Modifier.height(Dimens.height16))
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeContainerPreview() {
    SafeScreenContainerTest {
        WelcomeContainer()
    }
}
