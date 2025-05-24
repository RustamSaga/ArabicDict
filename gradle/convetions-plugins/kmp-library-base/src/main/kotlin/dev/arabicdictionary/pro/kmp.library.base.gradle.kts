package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.kmpConfig
import dev.arabicdictionary.pro.utils.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)

kmpConfig {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
        freeCompilerArgs.add("-opt-in=org.koin.core.annotation.KoinExperimentalAPI")

        // Code running from IDEA/Android Studio
        if (System.getProperty("idea.active") == "true"){
            // Turn on debug mode
            freeCompilerArgs = listOf("-Xdebug")
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.annotation)
            implementation(libs.kotlinx.datetime)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)

            implementation(libs.koin.test)
        }
    }
}