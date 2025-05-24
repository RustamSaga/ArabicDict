package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.composeExt
import dev.arabicdictionary.pro.utils.kmpConfig
import dev.arabicdictionary.pro.utils.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.compose.compiler.get().pluginId)
plugins.applyIfNeeded(libs.plugins.jetbrains.compose.multiplatform.get().pluginId)

kmpConfig {
    sourceSets {
        commonMain.dependencies {
            api(project(":core:uikit"))

            implementation(composeExt.dependencies.components.resources)
            implementation(composeExt.dependencies.components.uiToolingPreview)

            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.jetbrains.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(libs.koin.core.viewmodel)
            implementation(libs.koin.compose)
        }
    }
}