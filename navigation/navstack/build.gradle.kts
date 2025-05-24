import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.navigation.core)
                implementation(libs.kotlinx.serialization.core)
            }
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.navstate.stack"
}