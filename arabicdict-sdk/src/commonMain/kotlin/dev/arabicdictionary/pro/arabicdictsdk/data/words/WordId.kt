package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a reference to a base word, including its form and grammatical category.
 *
 * Used to reference other words (e.g., synonyms, grammatical forms, etc.) in a compact way.
 *
 * @property id The unique identifier of the word.
 * @property arabicVoweled The word in Arabic with diacritical marks (التشكيل).
 * @property arabicUnvoweled The word in Arabic without diacritical marks.
 * @property baseWordType The base grammatical type of the word (e.g., noun, verb).
 *
 * ### Example:
 * ```kotlin
 * val wordRef = WordId(
 *     id = 12,
 *     arabicVoweled = "مُدَرِّسٌ",
 *     arabicUnvoweled = "مدرس",
 *     baseWordType = BaseWordType(id = 1, arabicVoweled = "اِسْمٌ", arabicUnvoweled = "اسم")
 * )
 * ```
 */
@Serializable
data class WordId(
    @SerialName("id") val id: Int, // Unique word identifier.
    @SerialName("arabic_voweled") val arabicVoweled: String, // Arabic form with diacritics.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String, // Arabic form without diacritics.
    @SerialName("base_word_type") val baseWordType: BaseWordType
)
