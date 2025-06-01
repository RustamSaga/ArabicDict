plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.arabicdict.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.arabicdictSdk)
            implementation(projects.features.auth.ui)
            implementation(projects.navigation.compose)
            implementation(projects.featuresCommon)
            implementation(libs.kotlinx.serialization.json)
            implementation(projects.core.utils)
            implementation(libs.datastore.preferences)
            implementation(libs.datastore)
            implementation(libs.koin.compose.viewmodel)
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.composeapp"
}

