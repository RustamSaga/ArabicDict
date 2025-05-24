package dev.arabicdictionary.pro.arabicdict

import android.app.Application
import dev.arabicdictionary.pro.BuildConfig
import dev.arabicdictionary.pro.arabicdict.common.app.initKoinApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArabicDictApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArabicDictApp)
            initKoinApp(
                platformContext = this@ArabicDictApp,
                isDebug = BuildConfig.DEBUG,
            )
        }
    }
}