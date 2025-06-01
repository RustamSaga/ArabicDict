package dev.arabicdictionary.pro.core.uikit.localization

import androidx.compose.runtime.compositionLocalOf

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class ArabicDictLocalization {
    fun applyLanguage(iso: String)
    fun selectedLanguage(): String
}

internal fun localArabicDictLocalization(platformContext: PlatformContext) = compositionLocalOf { locale(platformContext = platformContext) }

expect fun locale(platformContext: PlatformContext): String
