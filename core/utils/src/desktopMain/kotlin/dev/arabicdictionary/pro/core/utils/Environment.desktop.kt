package dev.arabicdictionary.pro.core.utils

public actual val currentEnvironment: Environment = DesktopEnvironment

public object DesktopEnvironment : Environment {
    override val osName: String
        get() = System.getProperty("os.name") ?: ""

    override val osVersion: String
        get() = System.getProperty("os.version") ?: ""
}