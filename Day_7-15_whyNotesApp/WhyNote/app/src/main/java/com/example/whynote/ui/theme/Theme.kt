package com.example.compose
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.whynote.ui.theme.AppTypography
import com.example.whynote.ui.theme.backgroundDark
import com.example.whynote.ui.theme.backgroundLight
import com.example.whynote.ui.theme.errorContainerDark
import com.example.whynote.ui.theme.errorContainerLight
import com.example.whynote.ui.theme.errorDark
import com.example.whynote.ui.theme.errorLight
import com.example.whynote.ui.theme.inverseOnSurfaceDark
import com.example.whynote.ui.theme.inverseOnSurfaceLight
import com.example.whynote.ui.theme.inversePrimaryDark
import com.example.whynote.ui.theme.inversePrimaryLight
import com.example.whynote.ui.theme.inverseSurfaceDark
import com.example.whynote.ui.theme.inverseSurfaceLight
import com.example.whynote.ui.theme.onBackgroundDark
import com.example.whynote.ui.theme.onBackgroundLight
import com.example.whynote.ui.theme.onErrorContainerDark
import com.example.whynote.ui.theme.onErrorContainerLight
import com.example.whynote.ui.theme.onErrorDark
import com.example.whynote.ui.theme.onErrorLight
import com.example.whynote.ui.theme.onPrimaryContainerDark
import com.example.whynote.ui.theme.onPrimaryContainerLight
import com.example.whynote.ui.theme.onPrimaryDark
import com.example.whynote.ui.theme.onPrimaryLight
import com.example.whynote.ui.theme.onSecondaryContainerDark
import com.example.whynote.ui.theme.onSecondaryContainerLight
import com.example.whynote.ui.theme.onSecondaryDark
import com.example.whynote.ui.theme.onSecondaryLight
import com.example.whynote.ui.theme.onSurfaceDark
import com.example.whynote.ui.theme.onSurfaceLight
import com.example.whynote.ui.theme.onSurfaceVariantDark
import com.example.whynote.ui.theme.onSurfaceVariantLight
import com.example.whynote.ui.theme.onTertiaryContainerDark
import com.example.whynote.ui.theme.onTertiaryContainerLight
import com.example.whynote.ui.theme.onTertiaryDark
import com.example.whynote.ui.theme.onTertiaryLight
import com.example.whynote.ui.theme.outlineDark
import com.example.whynote.ui.theme.outlineLight
import com.example.whynote.ui.theme.outlineVariantDark
import com.example.whynote.ui.theme.outlineVariantLight
import com.example.whynote.ui.theme.primaryContainerDark
import com.example.whynote.ui.theme.primaryContainerLight
import com.example.whynote.ui.theme.primaryDark
import com.example.whynote.ui.theme.primaryLight
import com.example.whynote.ui.theme.scrimDark
import com.example.whynote.ui.theme.scrimLight
import com.example.whynote.ui.theme.secondaryContainerDark
import com.example.whynote.ui.theme.secondaryContainerLight
import com.example.whynote.ui.theme.secondaryDark
import com.example.whynote.ui.theme.secondaryLight
import com.example.whynote.ui.theme.surfaceDark
import com.example.whynote.ui.theme.surfaceDimDark
import com.example.whynote.ui.theme.surfaceDimLight
import com.example.whynote.ui.theme.surfaceLight
import com.example.whynote.ui.theme.surfaceVariantDark
import com.example.whynote.ui.theme.surfaceVariantLight
import com.example.whynote.ui.theme.tertiaryContainerDark
import com.example.whynote.ui.theme.tertiaryContainerLight
import com.example.whynote.ui.theme.tertiaryDark
import com.example.whynote.ui.theme.tertiaryLight


private val darkScheme = darkColorScheme(
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
    surfaceTint = surfaceDimDark,
)


private val lightScheme = lightColorScheme(
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
    surfaceTint = surfaceDimLight,

)



@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun WhyNoteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

