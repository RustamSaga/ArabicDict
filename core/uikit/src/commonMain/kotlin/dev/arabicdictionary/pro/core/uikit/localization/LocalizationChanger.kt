package dev.arabicdictionary.pro.core.uikit.localization

import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object LocalizationChanger: KoinComponent {
    private val localization = get<ArabicDictLocalization>()

    fun update(lang: ArabicDictLanguage) {
        localization.applyLanguage(lang.iso)
    }

    fun current(): String {
        return localization.selectedLanguage()
    }
}
