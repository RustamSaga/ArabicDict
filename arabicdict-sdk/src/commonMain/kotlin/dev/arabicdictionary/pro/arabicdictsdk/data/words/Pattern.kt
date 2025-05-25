package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a morphological pattern (وزن) of a word in Arabic.
 * This class encapsulates both the stem and lemma forms of the word, with and without diacritical marks (tashkīl).
 * Additionally, it includes the type and length of the pattern.
 *
 * @property id The unique identifier for the word pattern.
 * @property arabicVoweled The pattern with vowel marks (tashkīl), used in fully vocalized words.
 * @property arabicUnvoweled The pattern without vowel marks (tashkīl), used in unvocalized words.
 * @property type The type of the pattern
 *      (e.g., "Diacritical Stem (DS)", "Canonical Stem (CS)", "Diacritical Lemma (DL)", Canonical Lemma (CL)).
 * @property length The length of the pattern, often in terms of the number of syllables or letters.
 *
 * These patterns are used in morphological analysis to determine how a word is derived and classified,
 * including its form and role in a sentence.
 *
 * ### Example usage:
 * ```kotlin
 * val pattern = WordPattern(
 *     id = 23,
 *     arabicVoweled = "فِعَّ",
 *     arabicUnvoweled = "فع",
 *     type = "DS",
 *     length = 2
 * )
 * ```
 */
@Serializable
data class Pattern(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("type") val type: String,
    @SerialName("length") val length: Int,
)
