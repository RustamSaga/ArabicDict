package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.ProjectTargets
import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.javaVersion
import dev.arabicdictionary.pro.utils.jvmTarget
import dev.arabicdictionary.pro.utils.kotlinJvmCompilerOptions
import dev.arabicdictionary.pro.utils.libs
import org.gradle.kotlin.dsl.dependencies

plugins.apply("dev.arabicdictionary.pro.android.base")
if (plugins.hasPlugin(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)) {
    plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.android.get().pluginId)
}

project.dependencies {
    "implementation"(libs.kotlinx.coroutines.android)
    "implementation"(libs.androidx.core.ktx)
    "implementation"(libs.androidx.annotation)
}

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
    freeCompilerArgs.add("-Xjdk-release=${libs.javaVersion(ProjectTargets.Android)}")
    freeCompilerArgs.add("-Xexpect-actual-classes")
    freeCompilerArgs.add("-opt-in=org.koin.core.annotation.KoinExperimentalAPI")
}