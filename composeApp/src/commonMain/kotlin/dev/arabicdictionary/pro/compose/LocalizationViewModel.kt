package dev.arabicdictionary.pro.compose

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.arabicdictionary.pro.core.uikit.localization.ArabicDictLanguage
import dev.arabicdictionary.pro.core.uikit.localization.LocalizationChanger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private const val LOCALE_KEY = "localization"

internal class LocalizationViewModel(
    private val prefs: DataStore<Preferences>
): ViewModel() {

    private val _state = MutableStateFlow(LocalizationChanger.current())
    val state = _state.asStateFlow()

    private val localeKey = stringPreferencesKey(LOCALE_KEY)

    init {
        viewModelScope.launch {
            prefs.data
                .map { preferences ->
                    val iso = preferences[localeKey] ?: "en"
                    ArabicDictLanguage.getByIso(iso)
                }
                .collect { language ->
                    LocalizationChanger.update(language)
                    _state.value = language.iso
                }
        }
    }

    fun update(lang: ArabicDictLanguage) {

        viewModelScope.launch {
            prefs.edit { preferences ->
                val counterKey = stringPreferencesKey(LOCALE_KEY)
                preferences[counterKey] = lang.iso
            }
            LocalizationChanger.update(lang)
            _state.value = LocalizationChanger.current()
        }

    }
}

