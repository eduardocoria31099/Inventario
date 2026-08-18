/*
 * MainViewController.kt
 * Copyright (c) 2026. All rights reserved
*/
package com.software.inventario

import androidx.compose.ui.window.ComposeUIViewController
import com.software.inventario.presentation.controller.NavigationController
import com.software.inventario.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun MainViewController() = ComposeUIViewController(
    configure = {
        // Logs KMP
        Napier.base(DebugAntilog())
        // DI KMP
        initKoin()
    },
) {
    NavigationController()
}
