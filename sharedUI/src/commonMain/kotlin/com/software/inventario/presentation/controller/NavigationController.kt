/*
 * NavigationController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.presentation.controller

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.software.inventario.presentation.welcome.navigation.WelcomeScreenInstance
import com.software.inventario.theme.AppTheme

@Composable
fun NavigationController() {
    AppTheme {
        Navigator(screen = WelcomeScreenInstance) { navigator ->
            ScaleTransition(navigator)
        }
    }
}
