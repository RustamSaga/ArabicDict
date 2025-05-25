package dev.arabicdictionary.pro.core.utils

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

public actual class UrlLauncher {
    public actual fun openUrl(
        url: String,
        context: PlatformContext?,
    ): Boolean {
        val nsUrl = NSURL.URLWithString(url) ?: return false
        UIApplication.sharedApplication.openURL(nsUrl)
        return true
    }
}
