package dev.arabicdictionary.pro.navstate.stack

import dev.arabicdictionary.pro.navstate.NavDest
import kotlinx.serialization.Serializable

sealed interface TestNavDestinations : NavDest {
    @Serializable
    data object Root : TestNavDestinations

    @Serializable
    data object DataList : TestNavDestinations

    @Serializable
    data class Details(
        val dataId: String,
    ) : TestNavDestinations
}
