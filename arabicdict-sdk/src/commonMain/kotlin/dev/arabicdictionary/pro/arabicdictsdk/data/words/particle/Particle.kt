package dev.arabicdictionary.pro.arabicdictsdk.data.words.particle

import dev.arabicdictionary.pro.arabicdictsdk.data.words.Category
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Meanings
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Particle(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: List<String>,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("cliticType") val cliticType: CliticType,
    @SerialName("meanings") val meanings: List<Meanings>,
    @SerialName("word_types") val wordTypes: List<WordType>,
    @SerialName("categories") val categories: List<Category>
)
