package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerbPattern(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("type") val type: String,
    @SerialName("length") val length: Int
)
