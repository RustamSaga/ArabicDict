package dev.arabicdictionary.pro.core.uikit.localization

import androidx.compose.ui.text.intl.Locale
import platform.Foundation.NSUserDefaults

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ArabicDictLocalization {
    actual fun applyLanguage(iso: String) {
        NSUserDefaults.standardUserDefaults.setObject(
            arrayListOf(iso), "AppleLanguages"
        )
        NSUserDefaults.standardUserDefaults.synchronize()
    }

    actual fun selectedLanguage(): String {
        return Locale.current.language
    }

}

actual fun locale(platformContext: PlatformContext): String {
    val langCode = Locale.current.language
    return langCode
}
