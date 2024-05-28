package io.ugochukwu.demoapplication.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    secondary = Grey,
    tertiary = White,
    surface = Black,
    background = Black,
    onPrimary = White,
    onSecondary = DarkText,
    onBackground = SecondaryText,
    onSurface = White,
    error = Red,
    onError = White,
    primaryContainer = Blue,
    secondaryContainer = Grey,
    errorContainer = Red
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    secondary = Grey,
    tertiary = White,
    surface = White,
    background = LightGrey,
    onPrimary = White,
    onSecondary = DarkText,
    onBackground = SecondaryText,
    onSurface = DarkText,
    error = Red,
    onError = White,
    primaryContainer = Blue,
    secondaryContainer = Grey,
    errorContainer = Red
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//        val context = LocalContext.current
//        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
      SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.surface.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
      }
    }

    MaterialTheme(
      colorScheme = colorScheme,
      typography = typography(darkTheme),
      content = content
    )
}