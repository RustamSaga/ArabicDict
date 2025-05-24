package dev.arabicdictionary.pro

import dev.arabicdictionary.pro.utils.applyIfNeeded
import dev.arabicdictionary.pro.utils.config.IOSPlatform
import dev.arabicdictionary.pro.utils.kmpConfig
import dev.arabicdictionary.pro.utils.config.kmpIosPlatforms
import dev.arabicdictionary.pro.utils.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)
plugins.applyIfNeeded("dev.arabicdictionary.pro.kmp.library.base")

kmpConfig {
    kmpIosPlatforms.asSequence()
        .map {
            when (it) {
                IOSPlatform.ARM_64 -> iosArm64()
                IOSPlatform.SIMULATOR_ARM64 -> iosSimulatorArm64()
                IOSPlatform.SIMULATOR_X64 -> iosX64()
            }
        }.forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = project.name
                isStatic = true
            }
        }
}

tasks.register("compileKotlinIosAll") {
    group = "build"
    description = "Compiles klib for all iOS targets"
    val kmpIosPlatforms = kmpIosPlatforms
    enabled = kmpIosPlatforms.isNotEmpty()
    kmpIosPlatforms.forEach { iosPlatform ->
        when (iosPlatform) {
            IOSPlatform.ARM_64 -> dependsOn(tasks.named("compileKotlinIosArm64"))
            IOSPlatform.SIMULATOR_ARM64 -> dependsOn(tasks.named("compileKotlinIosSimulatorArm64"))
            IOSPlatform.SIMULATOR_X64 -> dependsOn(tasks.named("compileKotlinIosX64"))
        }
    }
}