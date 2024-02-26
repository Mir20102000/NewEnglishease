package com.example.englishease.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF7B5800)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFDEA5)
val md_theme_light_onPrimaryContainer = Color(0xFF261900)
val md_theme_light_secondary = Color(0xFF4B6700)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFC4F263)
val md_theme_light_onSecondaryContainer = Color(0xFF141F00)
val md_theme_light_tertiary = Color(0xFF006D31)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFF97F8A8)
val md_theme_light_onTertiaryContainer = Color(0xFF00210A)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1E1B16)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1E1B16)
val md_theme_light_surfaceVariant = Color(0xFFEEE1CF)
val md_theme_light_onSurfaceVariant = Color(0xFF4E4639)
val md_theme_light_outline = Color(0xFF7F7667)
val md_theme_light_inverseOnSurface = Color(0xFFF8EFE7)
val md_theme_light_inverseSurface = Color(0xFF34302A)
val md_theme_light_inversePrimary = Color(0xFFFDBB20)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF7B5800)
val md_theme_light_outlineVariant = Color(0xFFD1C5B4)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFFDBB20)
val md_theme_dark_onPrimary = Color(0xFF412D00)
val md_theme_dark_primaryContainer = Color(0xFF5D4200)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFDEA5)
val md_theme_dark_secondary = Color(0xFFA9D54A)
val md_theme_dark_onSecondary = Color(0xFF253600)
val md_theme_dark_secondaryContainer = Color(0xFF374E00)
val md_theme_dark_onSecondaryContainer = Color(0xFFC4F263)
val md_theme_dark_tertiary = Color(0xFF7CDB8E)
val md_theme_dark_onTertiary = Color(0xFF003916)
val md_theme_dark_tertiaryContainer = Color(0xFF005323)
val md_theme_dark_onTertiaryContainer = Color(0xFF97F8A8)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1E1B16)
val md_theme_dark_onBackground = Color(0xFFE9E1D9)
val md_theme_dark_surface = Color(0xFF1E1B16)
val md_theme_dark_onSurface = Color(0xFFE9E1D9)
val md_theme_dark_surfaceVariant = Color(0xFF4E4639)
val md_theme_dark_onSurfaceVariant = Color(0xFFD1C5B4)
val md_theme_dark_outline = Color(0xFF9A8F80)
val md_theme_dark_inverseOnSurface = Color(0xFF1E1B16)
val md_theme_dark_inverseSurface = Color(0xFFE9E1D9)
val md_theme_dark_inversePrimary = Color(0xFF7B5800)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFFDBB20)
val md_theme_dark_outlineVariant = Color(0xFF4E4639)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFFEAAB00)


// These colors from login screen tutorial (MUST REPLACE WITH MY THEME COLORS)
val Black = Color(0xFF000113)
val LightBlueWhite = Color(0xFFF1F5F9) //Social media background
val BlueGray = Color(0xFF334155)

val ColorScheme.focusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF94A3B8) else Color(0xFF475569)

val ColorScheme.textFieldContainer
    @Composable
    get() = if (isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite
