package dev.arabicdictionary.pro.core.uikit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import dev.arabicdictionary.pro.core.uikit.localization.PlatformContext
import dev.arabicdictionary.pro.core.uikit.localization.localArabicDictLocalization

@Composable
fun ArabicDictTheme(
    localization: String,
    platformContext: PlatformContext,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    colors: ColorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme(),
    typography: Typography = typography(),
    shapes: Shapes = shapes(),
    content: @Composable () -> Unit,
) {

    CompositionLocalProvider(
        LocalColorScheme provides colors,
        LocalShapes provides shapes,
        localArabicDictLocalization(platformContext = platformContext) provides localization
    ) {
        MaterialTheme(
            colorScheme = colors.toM3ColorScheme(),
            typography = typography,
            shapes = shapes.toM3Shapes(),
            content = content,
        )
    }
}

object ArabicDictTheme {
    val colors: ColorScheme
        @[Composable ReadOnlyComposable] get() = LocalColorScheme.current

    val typography: Typography
        @[Composable ReadOnlyComposable] get() = MaterialTheme.typography

    val shapes: Shapes
        @[Composable ReadOnlyComposable] get() = LocalShapes.current
}
