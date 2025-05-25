package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the **base grammatical type** of a word in Arabic morphology (الصرف).
 *
 * This classification is foundational in Arabic grammar and determines how a word behaves syntactically and morphologically.
 *
 * @property id The unique identifier of the base type.
 * @property arabicVoweled The name of the type in Arabic with diacritics (e.g., "اِسْمٌ").
 * @property arabicUnvoweled The name of the type in Arabic without diacritics (e.g., "اسم").
 *
 * ### Common types:
 * - **اِسْمٌ (اسم)**: *Noun* — e.g., "كِتَابٌ", "مُعَلِّمٌ"
 * - **فِعْلٌ (فعل)**: *Verb* — e.g., "كَتَبَ", "يَذْهَبُ"
 * - **حَرْفٌ (حرف)**: *Particle* — e.g., "في", "أن", "لم"
 *
 * ### Example usage:
 * ```kotlin
 * val nounType = BaseWordType(
 *     id = 1,
 *     arabicVoweled = "اِسْمٌ",
 *     arabicUnvoweled = "اسم"
 * )
 *
 * val verbType = BaseWordType(
 *     id = 2,
 *     arabicVoweled = "فِعْلٌ",
 *     arabicUnvoweled = "فعل"
 * )
 *
 * val particleType = BaseWordType(
 *     id = 3,
 *     arabicVoweled = "حَرْفٌ",
 *     arabicUnvoweled = "حرف"
 * )
 * ```
 */
@Serializable
data class BaseWordType(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
)
