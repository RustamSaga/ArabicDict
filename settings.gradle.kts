rootProject.name = "ArabicDictionaryPro"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("gradle/convetions-plugins")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

private fun isDirectoryGradleModule(file: File): Boolean {
    val buildGradleFile = File(file, "build.gradle.kts")
    return file.isDirectory && buildGradleFile.isFile && buildGradleFile.exists()
}

private fun includeAllModules(dir: String) {
    file(dir)
        .listFiles { dirFile -> isDirectoryGradleModule(dirFile) }
        ?.forEach { dirFile -> include(":${dir.replace('/', ':')}:${dirFile.name}") }
}

includeAllModules(dir = "core")
includeAllModules(dir = "navigation")
includeAllModules(dir = "features/auth")

include(":composeApp")
include(":arabicdict-app")
project(":arabicdict-app").name = "ArabicDictApp"
include(":arabicdict-sdk")
include(":features-common")
