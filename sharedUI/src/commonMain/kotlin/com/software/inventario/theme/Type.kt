/*
 * Type.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import inventario.sharedui.generated.resources.Res
import inventario.sharedui.generated.resources.open_sans
import org.jetbrains.compose.resources.Font

val fontFamily
    @Composable get() = FontFamily(
        Font(resource = Res.font.open_sans, weight = FontWeight.Normal),
        Font(resource = Res.font.open_sans, weight = FontWeight.Bold),
    )

val MaterialThemAppTypography
    @Composable
    get() = Typography(
        headlineLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
    )

@Immutable
data class AppTypography(
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
)

val appTypography
    @Composable get() = AppTypography(
        bodyLarge = TextStyle(fontFamily = fontFamily, fontSize = 24.sp),
        bodyMedium = TextStyle(fontFamily = fontFamily, fontSize = 18.sp),
        bodySmall = TextStyle(fontFamily = fontFamily, fontSize = 16.sp),
    )

@Immutable
data class AppSpanStyle(
    val bodyLarge: SpanStyle,
)

val appSpanStyle @Composable get() =
    AppSpanStyle(bodyLarge = SpanStyle(fontFamily = fontFamily, fontSize = 24.sp))
