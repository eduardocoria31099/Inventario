/*
 * WelcomeUiEvent.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.presentation.welcome.viewmodel

sealed class WelcomeUiEvent {
    internal data object Idle : WelcomeUiEvent()
    data object ShowVersionInfoDialog : WelcomeUiEvent()
}
