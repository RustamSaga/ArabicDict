import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.arabicdict.kmplib)
    alias(libs.plugins.arabicdict.compose)
    alias(libs.plugins.manifestGuard)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.composeApp)
            implementation(projects.core.utils)
            implementation(compose.components.resources)
            api(libs.datastore.preferences)
            api(libs.datastore)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.material)
        }
    }

    compilerOptions {
        // Code running from IDEA/Android Studio
        if (System.getProperty("idea.active") == "true"){
            // Turn on debug mode
            freeCompilerArgs = listOf("-Xdebug")
        }
    }
}

compose.desktop {
    application {
        mainClass = "dev.arabicdictionary.pro.arabicdict.ArabicDict"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dev.arabicdictionary.pro"
            packageVersion = "1.0.0"

            windows {
                iconFile.set(project.file("src/desktopMain/resources/icons/app-icon.ico"))
            }

            macOS {
                iconFile.set(project.file("src/desktopMain/resources/icons/app-icon.icns"))
            }

            linux {
                iconFile.set(project.file("src/desktopMain/resources/icons/app-icon.png"))
            }
        }
    }
}

android {
    namespace = "dev.arabicdictionary.pro"

    defaultConfig {
        applicationId = "dev.arabicdictionary.pro"
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")

            // Disables PNG crunching for the "release" build type.
            isCrunchPngs = false
        }
    }

    androidResources {
        generateLocaleConfig = false
        localeFilters += setOf("ru","en","ar")
    }

    lint {
        checkReleaseBuilds = false
        checkDependencies = true
    }

    buildFeatures {
        buildConfig = true
    }
}

androidComponents.beforeVariants { variant ->
    manifestGuard {
        guardVariant(variant.name) {
            enabled = true
            compareOnAssemble = false

            val baseDir = layout.projectDirectory.dir("manifest/${variant.name}")
            referenceFile = baseDir.file("manifest-original.xml.xml")
            htmlDiffFile = baseDir.file("manifest-diff.html")

            ignore {
                ignoreAppVersionChanges = true
            }
        }
    }
}
