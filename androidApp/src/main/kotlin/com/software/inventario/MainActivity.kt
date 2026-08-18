/*
 * MainActivity.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import com.software.inventario.platform.biometric.ActivityProvider
import com.software.inventario.presentation.controller.NavigationController

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { false }
        ActivityProvider.set(this)
        setContent {
            NavigationController()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    NavigationController()
}
