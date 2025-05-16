package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Represents synonym and antonym relations for a noun or verb.
 */
@Serializable
data class Relations(
    @SerialName("synonyms") val synonyms: List<WordId>,
    @SerialName("antonyms") val antonyms: List<WordId>
)