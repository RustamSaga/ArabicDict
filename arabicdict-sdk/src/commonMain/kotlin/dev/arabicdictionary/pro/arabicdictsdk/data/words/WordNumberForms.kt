package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the different number forms (singular, dual, and plural) of a word in Arabic.
 * This class holds references to the word in its different forms, represented as [WordId].
 *
 * @property singular The singular form of the word, represented as [WordId].
 * @property dual The dual form of the word, represented as [WordId].
 * @property plural The plural form of the word, represented as [WordId].
 *
 * ### Example usage:
 * ```kotlin
 * val wordForms = WordNumberForms(
 *     singular = WordId(id = 1, arabicVoweled = "كتاب", arabicUnvoweled = "كتاب"),
 *     dual = WordId(id = 2, arabicVoweled = "كتابان", arabicUnvoweled = "كتابان"),
 *     plural = WordId(id = 3, arabicVoweled = "كتب", arabicUnvoweled = "كتب")
 * )
 * ```
 */
@Serializable
data class WordNumberForms(
    @SerialName("singular") val singular: WordId, // The singular form of the word.
    @SerialName("dual") val dual: WordId,         // The dual form of the word.
    @SerialName("plural") val plural: WordId      // The plural form of the word.
)
