package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the root (جذر) of a word in Arabic morphology.
 *
 * In Arabic linguistics, a root typically consists of 3 to 5 consonantal letters
 * that form the semantic foundation of derived words (e.g., "كتب" for writing-related words).
 *
 * @property length The number of consonants in the root (commonly 3 or 4).
 * @property value The root itself as a string, composed of Arabic consonants without diacritics.
 *
 * ### Example:
 * ```kotlin
 * val root = Root(length = 3, value = "كتب") // root for words like "كاتب", "مكتوب", "كتاب"
 * ```
 */
@Serializable
data class Root(
    @SerialName("length") val length: Int, // Number of consonants in the root.
    @SerialName("value") val value: String, // The root letters (e.g., "كتب").
)
