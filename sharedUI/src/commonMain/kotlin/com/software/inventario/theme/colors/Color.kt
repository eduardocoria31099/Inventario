/*
 * Color.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.theme.colors

import androidx.compose.ui.graphics.Color

// --- Light colors ---
val primaryLight = Color(0xFF007BFF)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryContainerLight = Color(0xFFE6F4F4)
val onPrimaryContainerLight = Color(0xFF637070)
val secondaryLight = Color(0xFFA3A3A3)
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFDCE0E0)
val onSecondaryContainerLight = Color(0xFF5F6363)
val tertiaryLight = Color(0xFFCB5856)
val onTertiaryLight = Color(0xFFFFFFFF)
val tertiaryContainerLight = Color(0xFFF3EFFE)
val onTertiaryContainerLight = Color(0xFF6E6C78)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF93000A)
val backgroundLight = Color(0xFFF4F4F4)
val onBackgroundLight = Color(0xFF1B1C1C)
val surfaceLight = Color(0xFFFBF9F8)
val onSurfaceLight = Color(0xFF1B1C1C)
val surfaceVariantLight = Color(0xFFDFE3E3)
val onSurfaceVariantLight = Color(0xFF424848)
val outlineLight = Color(0xFF737878)
val outlineVariantLight = Color(0xFFC2C7C7)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF303030)
val inverseOnSurfaceLight = Color(0xFFF3F0EF)
val inversePrimaryLight = Color(0xFFBBC9C9)
val surfaceDimLight = Color(0xFFDCD9D9)
val surfaceBrightLight = Color(0xFFFBF9F8)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFF5F3F2)
val surfaceContainerLight = Color(0xFFF0EDED)
val surfaceContainerHighLight = Color(0xFFEAE8E7)
val surfaceContainerHighestLight = Color(0xFFE4E2E1)
// --- Light Status Colors ---
val statusErrorLight = Color(0xFFF75555)
val statusErrorContainerLight = Color(0xFFFFEFED)
val statusWarningLight = Color(0xFFFACC15)
val statusWarningContainerLight = Color(0xFFFFFBEB)
val statusInfoLight = Color(0xFF235DFF)
val statusInfoContainerLight = Color(0xFFEBF8F3)
val statusSuccessLight = Color(0xFF12D18E)
val statusSuccessContainerLight = Color(0xFFEBF8F3)
// --- Light Texts Colors ---
val textBlackLight = Color(0xFF000000)
val textWhiteLight = Color(0xFFFFFFFF)
val textLinkLight = Color(0xFF1470D1)
// --- Dark Backgrounds Colors ---
val backgroundBlackLight = Color(0xFF000000)
val backgroundWhiteLight = Color(0xFFFFFFFF)
val backgroundYellowLight = Color(0xFFFFB700)

// --- Dark colors ---
val primaryDark = Color(0xFF007BFF)
val onPrimaryDark = Color(0xFF263333)
val primaryContainerDark = Color(0xFFD7E5E5)
val onPrimaryContainerDark = Color(0xFF5A6767)
val secondaryDark = Color(0xFFA3A3A3)
val onSecondaryDark = Color(0xFF2C3131)
val secondaryContainerDark = Color(0xFF434848)
val onSecondaryContainerDark = Color(0xFFB1B6B6)
val tertiaryDark = Color(0xFFCB5856)
val onTertiaryDark = Color(0xFF302F3A)
val tertiaryContainerDark = Color(0xFFE4E0EF)
val onTertiaryContainerDark = Color(0xFF65636F)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)
val backgroundDark = Color(0xFF3C3C3C)
val onBackgroundDark = Color(0xFFE4E2E1)
val surfaceDark = Color(0xFF3C3C3C)
val onSurfaceDark = Color(0xFFE4E2E1)
val surfaceVariantDark = Color(0xFF424848)
val onSurfaceVariantDark = Color(0xFFC2C7C7)
val outlineDark = Color(0xFF8C9291)
val outlineVariantDark = Color(0xFF424848)
val scrimDark = Color(0xFF000000)
val inverseSurfaceDark = Color(0xFFE4E2E1)
val inverseOnSurfaceDark = Color(0xFF303030)
val inversePrimaryDark = Color(0xFF546161)
val surfaceDimDark = Color(0xFF131313)
val surfaceBrightDark = Color(0xFF393939)
val surfaceContainerLowestDark = Color(0xFF0E0E0E)
val surfaceContainerLowDark = Color(0xFF1B1C1C)
val surfaceContainerDark = Color(0xFF1F2020)
val surfaceContainerHighDark = Color(0xFF2A2A2A)
val surfaceContainerHighestDark = Color(0xFF353535)
// --- Dark Status Colors ---
val statusErrorDark = Color(0xFFF87171)
val statusErrorContainerDark = Color(0xFF450A0A)
val statusWarningDark = Color(0xFFFDE047)
val statusWarningContainerDark = Color(0xFF422006)
val statusInfoDark = Color(0xFF60A5FA)
val statusInfoContainerDark = Color(0xFF1E3A8A)
val statusSuccessDark = Color(0xFF34D399)
val statusSuccessContainerDark = Color(0xFF064E3B)
// --- Dark Texts Colors ---
val textBlackDark = Color(0xFF000000)
val textWhiteDark = Color(0xFFFFFFFF)
val textLinkDark = Color(0xFF83CEF6)
// --- Dark Backgrounds Colors ---
val backgroundBlackDark = Color(0xFF000000)
val backgroundWhiteDark = Color(0xFFFFFFFF)
val backgroundYellowDark = Color(0xFFFFB700)

// --- Light color group ---
val lightModeAppColors = AppColors(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
    status = ColorStatus(
        error = statusErrorLight,
        errorContainer = statusErrorContainerLight,
        warning = statusWarningLight,
        warningContainer = statusWarningContainerLight,
        info = statusInfoLight,
        infoContainer = statusInfoContainerLight,
        success = statusSuccessLight,
        successContainer = statusSuccessContainerLight,
    ),
    text = ColorTexts(
        black = textBlackLight,
        white = textWhiteLight,
        link = textLinkLight,
    ),
    backgrounds = ColorBackgrounds(
        black = backgroundBlackLight,
        white = backgroundWhiteLight,
        yellow = backgroundYellowLight,
    ),
)

// --- Dark color group ---
val darkModeAppColors = AppColors(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
    status = ColorStatus(
        error = statusErrorDark,
        errorContainer = statusErrorContainerDark,
        warning = statusWarningDark,
        warningContainer = statusWarningContainerDark,
        info = statusInfoDark,
        infoContainer = statusInfoContainerDark,
        success = statusSuccessDark,
        successContainer = statusSuccessContainerDark,
    ),
    text = ColorTexts(
        black = textBlackDark,
        white = textWhiteDark,
        link = textLinkDark,
    ),
    backgrounds = ColorBackgrounds(
        black = backgroundBlackDark,
        white = backgroundWhiteDark,
        yellow = backgroundYellowDark,
    ),
)
