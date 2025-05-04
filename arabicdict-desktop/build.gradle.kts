import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
//    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.jetbrains.compose.multiplatform)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(projects.composeApp)
        }

    }
}

compose.desktop {
    application {
        mainClass = "dev.arabicdictionary.pro.ArabicDict"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dev.arabicdictionary.pro"
            packageVersion = "1.0.0"
        }
    }
}
