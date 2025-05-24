package dev.arabicdictionary.pro.arabicdict.common.app

import dev.arabicdictionary.pro.core.utils.PlatformContext
import dev.arabicdictionary.pro.core.utils.UrlLauncher
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun defaultKoinLogger(level: Level): Logger {
    return PrintLogger(level)
}

internal actual fun platformKoinModule(platformContext: PlatformContext): Module {
    return module {
        factory { UrlLauncher() }
    }
}