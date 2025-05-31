package dev.arabicdictionary.pro.core.uikit.localization

import kotlin.jvm.JvmField

actual abstract class PlatformContext private constructor() {
    companion object {
        @JvmField
        val INSTANCE: PlatformContext = object : PlatformContext() {}
    }
}
