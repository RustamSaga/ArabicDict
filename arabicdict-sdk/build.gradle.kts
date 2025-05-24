plugins {
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.ktorfit)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.contentNegotiation)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktorfit)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.engine.okhttp)
        }

        desktopMain.dependencies {
            implementation(libs.ktor.client.engine.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.engine.darwin)
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro.arabicdictsdk"
}