package dev.arabicdictionary.pro.arabicdictsdk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class SearchWord(
    @SerialName("accountId") private val accountId: String,
)
