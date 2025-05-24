package dev.arabicdictionary.pro.core.utils

import platform.UIKit.UIDevice

public actual val currentEnvironment: Environment = iOSEnvironment

@Suppress("ClassNaming", "ClassName")
public object iOSEnvironment : Environment {
    override val osName: String
        get() = UIDevice.currentDevice.systemName

    override val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
}