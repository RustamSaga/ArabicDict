package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a word variant as it appears in a specific dialect.
 * This class links a dialectal form of a word to its corresponding dialect, supporting both vocalized
 * and unvocalized representations of the word.
 *
 * @property id Unique identifier for the dialectal word form.
 * @property arabicVoweled The word form with diacritical marks (tashkīl), as used in the dialect.
 * @property arabicUnvoweled The word form without diacritical marks, reflecting the surface form of the dialect.
 * @property dialect The dialect in which this word form is used, including its metadata such as region and name.
 *
 * ### Example usage:
 * ```kotlin
 * val dialect = Dialect(
 *      id = 1,
 *      name = "Egyptian",
 *      region = "Egypt",
 *      description = "Most widely spoken variety in Egypt, characterized by its unique pronunciation and vocabulary."
 * )
 * val wordDialect = WordDialect(
 *     id = 101,
 *     arabicVoweled = "قِطّ",
 *     arabicUnvoweled = "قط",
 *     dialect = dialect
 * )
 * ```
 */
@Serializable
data class WordDialect(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("dialect") val dialect: Dialect
)

