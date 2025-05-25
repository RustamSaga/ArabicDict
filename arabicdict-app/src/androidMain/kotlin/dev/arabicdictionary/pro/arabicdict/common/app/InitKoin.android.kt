package dev.arabicdictionary.pro.arabicdict.common.app

import dev.arabicdictionary.pro.core.utils.PlatformContext
import dev.arabicdictionary.pro.core.utils.UrlLauncher
import org.koin.android.logger.AndroidLogger
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun defaultKoinLogger(level: Level): Logger = AndroidLogger(level)

internal actual fun platformKoinModule(platformContext: PlatformContext): Module =
    module {
        factory { UrlLauncher(platformContext) }
    }
