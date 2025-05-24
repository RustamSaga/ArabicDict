package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.composeExt
import dev.arabicdictionary.pro.utils.kmpConfig
import org.gradle.kotlin.dsl.getting

plugins.applyIfNeeded("dev.arabicdictionary.pro.jetbrains-compose.base")

kmpConfig {
    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(composeExt.dependencies.desktop.common)
            implementation(composeExt.dependencies.desktop.currentOs)
        }
    }
}