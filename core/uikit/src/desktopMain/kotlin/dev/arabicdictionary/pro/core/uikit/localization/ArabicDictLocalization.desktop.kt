package dev.arabicdictionary.pro.core.uikit.localization

import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ArabicDictLocalization {
    actual fun applyLanguage(iso: String) {
        val locale = Locale.forLanguageTag(iso)
        Locale.setDefault(locale)
    }

    actual fun selectedLanguage(): String {
        return Locale.getDefault().toLanguageTag()
    }
}

actual fun locale(platformContext: PlatformContext): String {
    return Locale.getDefault().toLanguageTag()
}
