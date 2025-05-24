import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

group = "dev.arabicdictionary.pro"
version = "0.1"

kotlin {
    explicitApi = ExplicitApiMode.Strict

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
            }
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.navstate.core"
}