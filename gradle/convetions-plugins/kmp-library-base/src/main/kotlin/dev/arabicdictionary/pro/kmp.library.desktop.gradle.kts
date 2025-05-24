package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.ProjectTargets
import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.jvmTarget
import dev.arabicdictionary.pro.utils.kmpConfig
import dev.arabicdictionary.pro.utils.libs
import org.gradle.kotlin.dsl.getting

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)
plugins.applyIfNeeded("dev.arabicdictionary.pro.kmp.library.base")

kmpConfig {
    jvm("desktop") {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.jvmTarget.set(libs.jvmTarget(ProjectTargets.Desktop))
            }
        }
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
        }

        val desktopTest by getting
        desktopTest.dependencies {
            implementation(libs.kotlin.test.junit)
        }
    }
}
