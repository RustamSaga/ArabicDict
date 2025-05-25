package dev.arabicdictionary.pro.core.utils

import android.os.Build

public actual val currentEnvironment: Environment = AndroidEnvironment

public object AndroidEnvironment : Environment {
    override val osName: String = "Android"

    override val osVersion: String
        get() = Build.VERSION.RELEASE
}
