package dev.arabicdictionary.pro.arabicdictsdk.data.words.particle

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CliticType(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
)
