/*
 * SharedModule.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.di

import com.software.inventario.presentation.welcome.viewmodel.WelcomeViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val viewmodelModule = module {
    viewModelOf(constructor = ::WelcomeViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            dispatcherModule,
            repositoryModule,
            useCaseModule,
            biometricModule,
            viewmodelModule,
        )
    }
}
