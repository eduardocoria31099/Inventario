/*
 * HeatScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.presentation.welcome.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kommon.versions.KommonVersions
import com.software.inventario.components.container.SafeScreenContainer
import com.software.inventario.components.container.SafeScreenContainerTest
import com.software.inventario.components.dialog.InfoDialog
import com.software.inventario.presentation.welcome.viewmodel.WelcomeUiEvent
import com.software.inventario.presentation.welcome.viewmodel.WelcomeViewModel
import com.software.inventario.theme.AppTheme
import com.software.inventario.utils.logs.Log
import com.software.inventario.utils.permission.PermissionRequestEffect
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.location.LOCATION
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.accept
import inventario.sharedui.generated.resources.app_info_body
import inventario.sharedui.generated.resources.idle
import inventario.sharedui.generated.resources.version_app
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = koinViewModel(),
    onNavigateToLogin: () -> Unit = {},
) {

    val welcomeUiEvent by viewModel.welcomeUiEvent.collectAsStateWithLifecycle()

    PermissionRequestEffect(
        permission = Permission.LOCATION,
        requestPermission = true,
    )

    SafeScreenContainer {
        WelcomeContainer(
            onNavigateToLogin = onNavigateToLogin,
            showDialogInfo = {
                Log.error(message = "error test")
                viewModel.showInfoDialog()
            },
        )
    }

    when (welcomeUiEvent) {
        WelcomeUiEvent.Idle -> {
            Log.info(message = stringResource(Res.string.idle))
        }
        WelcomeUiEvent.ShowVersionInfoDialog -> {
            InfoDialog(
                titleTextColor = AppTheme.colors.text.black,
                titleText = stringResource(Res.string.version_app),
                messageTextColor = AppTheme.colors.text.black,
                messageText = stringResource(
                    Res.string.app_info_body,
                    KommonVersions.APPLICATION_ID,
                    KommonVersions.BUILD_TYPE.name,
                    KommonVersions.VERSION_CODE,
                    KommonVersions.VERSION_NAME,
                ),
                primaryButtonBackgroundColor = AppTheme.colors.primary,
                primaryButtonTextColor = AppTheme.colors.text.white,
                primaryButtonText = stringResource(Res.string.accept),
                onPrimaryButtonClick = {
                    viewModel.resetUiEvent()
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    SafeScreenContainerTest {
        WelcomeScreen()
    }
}
