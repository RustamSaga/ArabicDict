package dev.arabicdictionary.pro.core.uikit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.material3.Typography

@Composable
fun ArabicDictTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    colors: ColorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme(),
    typography: Typography = typography(),
    shapes: Shapes = shapes(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColorScheme provides colors,
        LocalShapes provides shapes,
    ) {
        MaterialTheme(
            colorScheme = colors.toM3ColorScheme(),
            typography = typography,
            shapes = shapes.toM3Shapes(),
            content = content,
        )
    }
}

object FrameIOTheme {
    val colors: ColorScheme
        @[Composable ReadOnlyComposable] get() = LocalColorScheme.current

    val typography: Typography
        @[Composable ReadOnlyComposable] get() = MaterialTheme.typography

    val shapes: Shapes
        @[Composable ReadOnlyComposable] get() = LocalShapes.current
}