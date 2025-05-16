package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a formal definition of an Arabic word, including its original Arabic description
 * and a translated version in a specified target language.
 *
 * This model is useful for bilingual or multilingual dictionary entries,
 * where users need to see the meaning of an Arabic term and its equivalent meaning in another language.
 *
 * @property sourceName The name of the source (e.g., classical dictionary) from which the definition is taken.
 * @property id Unique identifier of this specific definition entry.
 * @property arabicWordId The ID of the original Arabic word being defined.
 * @property definition The core definition text written in Arabic.
 * @property translation The translated version of the Arabic definition.
 * @property language The language code or name of the translation (e.g., "en" for English, "fr" for French).
 *
 * ### Example:
 * ```kotlin
 * val def = Definition(
 *     sourceName = "المعجم الوسيط",
 *     id = 1,
 *     arabicWordId = 101,
 *     definition = "السير على الأقدام لمسافة قصيرة",
 *     translation = "Walking a short distance on foot",
 *     language = "en"
 * )
 * ```
 */
@Serializable
data class Definition(
    @SerialName("source_name") val sourceName: String, // Source of the definition.
    @SerialName("id") val id: Int,                     // Unique definition ID.
    @SerialName("arabic_word_id") val arabicWordId: Int,
    @SerialName("definition") val definition: String,   // The actual arabic definition text.
    @SerialName("translation") val translation: String,
    @SerialName("translation_language") val language: String
)

