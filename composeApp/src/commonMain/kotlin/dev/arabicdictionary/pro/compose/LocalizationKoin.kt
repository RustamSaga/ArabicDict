package dev.arabicdictionary.pro.compose

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal fun localizationKoinModule(): Module =
    module {
        viewModel {
            LocalizationViewModel(
                prefs = get<DataStore<Preferences>>()
            )
        }

        scope(localizationKoinScopeQualifier) {
            // Add scoped dependencies
        }
    }

internal const val LOCALIZATION_SCOPE_ID = "dev.arabicdictionary.pro.compose"

internal val localizationKoinScopeQualifier
    get() = named(LOCALIZATION_SCOPE_ID)
