package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.androidConfig
import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.compose.compiler.get().pluginId)

androidConfig {
    buildFeatures {
        compose = true
    }
}