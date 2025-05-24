package dev.arabicdictionary.pro.core.utils

public expect class UrlLauncher {
    public fun openUrl(
        url: String,
        context: PlatformContext? = null,
    ): Boolean
}