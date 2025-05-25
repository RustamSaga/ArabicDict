plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.utils)
            implementation(projects.navigation.core)
            implementation(libs.kotlinx.serialization.core)
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.common.features"
}
