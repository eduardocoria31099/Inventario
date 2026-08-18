/*
 * PermissionRequestEffect.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.utils.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.software.inventario.utils.logs.Log
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory

@Composable
fun PermissionRequestEffect(
    permission: Permission,
    requestPermission: Boolean,
    onResult: (Boolean) -> Unit = {},
) {
    val factory = rememberPermissionsControllerFactory()
    val controller = remember(key1 = factory) { factory.createPermissionsController() }

    BindEffect(permissionsController = controller)

    LaunchedEffect(key1 = requestPermission) {
        if (!requestPermission) return@LaunchedEffect

        try {
            Log.error(message = "Permission request successful")
            controller.providePermission(permission)
            onResult(controller.isPermissionGranted(permission))
        } catch (_: DeniedAlwaysException) {
            Log.error(message = "Permission denied always")
            onResult(false)
        } catch (_: DeniedException) {
            Log.error(message = "Permission denied")
            onResult(false)
        } catch (_: Exception) {
            Log.error(message = "Permission denied")
            onResult(false)
        }
    }
}
