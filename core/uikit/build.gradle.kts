plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.jetbrains.compose.multiplatform)
    alias(libs.plugins.jetbrains.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.ui)
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.uikit"

    buildFeatures {
        compose = true
    }

}
