package dev.arabicdictionary.pro.arabicdict.common.app

import dev.arabicdictionary.pro.core.utils.PlatformContext
import org.koin.core.KoinApplication
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.module.Module

internal expect fun defaultKoinLogger(level: Level): Logger

fun KoinApplication.initKoinApp(
    platformContext: PlatformContext,
    isDebug: Boolean,
    logLevel: Level = Level.INFO,
) {
    allowOverride(false)
    if (isDebug) {
        logger(defaultKoinLogger(logLevel))
    }

    modules(
        platformKoinModule(platformContext),
    )
}

internal expect fun platformKoinModule(platformContext: PlatformContext): Module