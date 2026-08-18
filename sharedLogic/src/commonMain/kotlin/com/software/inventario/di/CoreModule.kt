/*
 * CoreModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.di

import com.software.inventario.platform.biometric.BiometricProvider
import com.software.inventario.platform.biometric.getBiometricProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val biometricModule = module {
    single<BiometricProvider> {
        getBiometricProvider()
    }
}

val dispatcherModule = module {
    single<CoroutineDispatcher> { Dispatchers.IO }
}

val repositoryModule = module {}

val useCaseModule = module {}
