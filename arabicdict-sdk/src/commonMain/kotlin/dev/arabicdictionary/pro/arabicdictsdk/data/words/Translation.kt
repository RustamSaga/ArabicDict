package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a translation entry for an Arabic word into a specific target language.
 * Each instance links an Arabic word with one of its translations, including metadata
 * such as the language and associated meaning group.
 *
 * @property arabicWordId The unique identifier of the original Arabic word being translated.
 *                        This ID references a word entry in the Arabic lexicon.
 * @property translationWordId The unique identifier of the translated word in the target language.
 *                              This can be used to look up the translated word in a separate word table.
 * @property translate The literal translation of the word or phrase in the target language.
 *                     This is a human-readable form of the translated word.
 * @property language The ISO 639-1 code (or custom code) of the translation language (e.g., "en" for English, "fr" for French).
 * @property meaningId An identifier used to group translations that correspond to a specific meaning or sense
 *                     of the original Arabic word. This is useful when a word has multiple distinct meanings.
 *
 * ### Example:
 * ```kotlin
 * val translation = Translation(
 *     arabicWordId = 101,
 *     translationWordId = 205,
 *     translate = "book",
 *     language = "en",
 *     meaningId = 1
 * )
 * ```
 *
 * This translation links the Arabic word with ID `101` to the English word "book",
 * indicating that it's the first meaning group of the word.
 */

@Serializable
data class Translation(
    @SerialName("arabic_word_id") val arabicWordId: Int, // The ID of the word this translation refers to.
    @SerialName("translation_word_id") val translationWordId: Int,
    @SerialName("translate") val translate: String, // The translated word or phrase.
    @SerialName("language") val language: String,
    @SerialName("meaning_id") val meaningId: Int,
)
