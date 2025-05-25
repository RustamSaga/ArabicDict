plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.arabicdict.compose)
}

kotlin {
    explicitApi()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.uikit)
            implementation(projects.core.utils)
            implementation(projects.featuresCommon)
            implementation(projects.arabicdictSdk)
            implementation(projects.navigation.core)
            implementation(libs.koin.compose.viewmodel)
            implementation(compose.components.resources)
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.features.auth"
}
