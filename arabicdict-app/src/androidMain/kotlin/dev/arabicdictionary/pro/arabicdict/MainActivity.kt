package dev.arabicdictionary.pro.arabicdict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.arabicdictionary.pro.compose.ArabicDictComposeApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ArabicDictComposeApp(
                platformContext = applicationContext,
                onRootBack = { finish() },
            )
        }
    }
}
