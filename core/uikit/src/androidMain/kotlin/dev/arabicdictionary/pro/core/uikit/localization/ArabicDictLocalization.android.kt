package dev.arabicdictionary.pro.core.uikit.localization

import android.content.Context
import android.os.LocaleList
import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ArabicDictLocalization(
    private val context: Context
) {
    actual fun applyLanguage(iso: String) {
        val locale = Locale.forLanguageTag(iso)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocales(LocaleList(locale))
    }

    actual fun selectedLanguage(): String {
        val locales = context.resources.configuration.locales
        return if (locales.isEmpty) {
            Locale.getDefault().language
        } else {
            locales.get(0).language
        }
    }
}


actual fun locale(platformContext: Context): String {
    val locale =
        platformContext.resources.configuration.locales[0]
    return locale.toLanguageTag()
}
