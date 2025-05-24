package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.ProjectTargets
import dev.arabicdictionary.pro.utils.androidConfig
import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.jvmTarget
import dev.arabicdictionary.pro.utils.kmpConfig
import dev.arabicdictionary.pro.utils.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)
plugins.applyIfNeeded(
    libs.plugins.android.library.get().pluginId,
    libs.plugins.android.application.get().pluginId,
)
plugins.applyIfNeeded("dev.arabicdictionary.pro.kmp.library.base")

kmpConfig {
    applyDefaultHierarchyTemplate {
        common {
            group("nonAndroid") {
                withIos()
                withIosX64()
                withIosArm64()
                withIosSimulatorArm64()
                withNative()
                withJvm()
            }
        }
    }

    androidTarget {
        compilerOptions {
            jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.kotlinx.coroutines.android)

            implementation(libs.koin.android)
        }

        named("nonAndroidMain")

        val androidUnitTest by getting
        androidUnitTest.dependencies {
            implementation(libs.kotlin.test.junit)
            implementation(libs.junit)
        }
    }
}

androidConfig {
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }
}

plugins.apply("dev.arabicdictionary.pro.android.base")