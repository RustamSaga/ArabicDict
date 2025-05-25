package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the type or class of a word in Arabic morphology.
 * This includes both the fully vocalized (with diacritics) and unvocalized forms of the type name.
 *
 * Word types may include grammatical classifications such as:
 * - **اسم (noun)**: A word referring to a person, place, or thing.
 * - **فعل (verb)**: A word indicating an action or occurrence.
 * - **حرف (particle)**: A functional word that links or modifies other words.
 *
 * @property id Unique identifier for the word type.
 * @property arabicVoweled The type name with vowel marks (e.g., "اِسْمُ الجَلَالَةِ").
 * @property arabicUnvoweled The type name without vowel marks (e.g., "اسم الجلالة").
 *
 * ### Example usage:
 * ```kotlin
 * val nounType = WordType(id = 1, voweled = "اِسْمُ آلَةِ", unvoweled = "اسم آلة")
 * val verbType = WordType(id = 2, voweled = "اِسْمُ جَامِدِ", unvoweled = "اسم جامد")
 * ```
 */
@Serializable
data class WordType(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
)
