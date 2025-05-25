package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import dev.arabicdictionary.pro.arabicdictsdk.data.words.Category
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Meanings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contains the semantic description of a noun.
 */
@Serializable
data class Semantics(
    @SerialName("meanings") val meanings: List<Meanings>,
    @SerialName("categories") val categories: List<Category>,
)
