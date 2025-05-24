package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.androidConfig
import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.composeExt
import dev.arabicdictionary.pro.utils.kmpConfig
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke

plugins.applyIfNeeded("dev.arabicdictionary.pro.jetbrains-compose.base")
plugins.apply("dev.arabicdictionary.pro.jetpack-compose.base")

kmpConfig {
    androidConfig {
        buildFeatures {
            compose = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(composeExt.dependencies.preview)
        }
    }
}

dependencies {
    "debugImplementation"(composeExt.dependencies.uiTooling)
}