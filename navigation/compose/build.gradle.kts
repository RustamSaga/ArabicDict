import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.arabicdict.compose)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict

    sourceSets {
        commonMain {
            dependencies {
                api(projects.navigation.core)
                api(projects.navigation.navstack)
                implementation(libs.jetbrains.compose.ui.backhandler)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.activity.compose)
            }
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.navstate.compose"
}