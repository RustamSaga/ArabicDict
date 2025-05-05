@file:JvmName("ArabicDict")

package dev.arabicdictionary.pro

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.arabicdictionary.pro.compose.ArabicDictApp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ArabicDictionaryPro",
    ) {
        ArabicDictApp()
    }
}