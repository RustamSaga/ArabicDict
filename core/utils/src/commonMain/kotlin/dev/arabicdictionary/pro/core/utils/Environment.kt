package dev.arabicdictionary.pro.core.utils

public interface Environment {
    public val osName: String
    public val osVersion: String

    public companion object {
        public val current: Environment
            get() = currentEnvironment
    }
}

public expect val currentEnvironment: Environment
