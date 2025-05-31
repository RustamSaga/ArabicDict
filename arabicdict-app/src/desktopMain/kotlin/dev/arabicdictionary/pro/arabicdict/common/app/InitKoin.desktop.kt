package dev.arabicdictionary.pro.arabicdict.common.app

import dev.arabicdictionary.pro.core.uikit.localization.ArabicDictLocalization
import dev.arabicdictionary.pro.core.utils.PlatformContext
import dev.arabicdictionary.pro.core.utils.UrlLauncher
import dev.arabicdictionary.pro.core.utils.datastore.DATA_STORE_FILE_NAME
import dev.arabicdictionary.pro.core.utils.datastore.createDataStore
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun defaultKoinLogger(level: Level): Logger = PrintLogger(level)

internal actual fun platformKoinModule(platformContext: PlatformContext): Module =
    module {
        factory { UrlLauncher() }
        single { ArabicDictLocalization() }
        single {
            createDataStore {
                DATA_STORE_FILE_NAME
            }
        }
    }
