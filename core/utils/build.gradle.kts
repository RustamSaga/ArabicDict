plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.arabicdict.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.datastore.preferences)
            api(libs.datastore)
        }
    }

    explicitApi()
}

android {
    namespace = "dev.arabicdictionary.pro.utils"
}
