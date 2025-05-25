@file:JvmName("ArabicDict")

package dev.arabicdictionary.pro.arabicdict

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.arabicdictionary.pro.arabicdict.common.app.initKoinApp
import dev.arabicdictionary.pro.compose.ArabicDictComposeApp
import dev.arabicdictionary.pro.core.utils.PlatformContext
import org.koin.core.context.startKoin

@Suppress("ktlint:standard:function-signature")
fun main() =
    application {
        startKoin {
            initKoinApp(
                platformContext = PlatformContext.INSTANCE,
                isDebug = false,
            )
        }

        Window(
            onCloseRequest = ::exitApplication,
            title = "ArabicDict",
        ) {
            ArabicDictComposeApp(onRootBack = { exitApplication() })
        }
    }
