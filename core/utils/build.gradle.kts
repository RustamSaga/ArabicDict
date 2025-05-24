plugins {
    alias(libs.plugins.arabicdict.kmplib)
}

kotlin {
    sourceSets {
    }

    explicitApi()
}

android {
    namespace = "dev.arabicdictionary.pro.utils"
}