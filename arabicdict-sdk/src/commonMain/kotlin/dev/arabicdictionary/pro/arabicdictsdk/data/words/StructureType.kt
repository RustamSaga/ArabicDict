package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the morphological structure type (نوع البنية) of a word in Arabic.
 *
 * This refers to the internal root structure of a word and is used in morphological analysis.
 * Examples vary depending on whether the word is a noun or a verb.
 *
 * ### For nouns (الأسماء):
 * - **صحيح**: Regular, unaltered structure.
 * - **مقصور**: Ends with an alif maqṣūra (ى).
 * - **ممدود**: Ends with a hamza preceded by an alif (ـاء).
 * - **مقصوص**: Truncated or shortened form.
 *
 * ### For verbs (الأفعال):
 * - **صحيح**: A verb with no weak letters (like "كَتَبَ").
 * - **مهموز**: Contains a hamza.
 * - **مثال**: Begins with a weak letter (like "وَعَدَ").
 * - **أجوف**: Has a weak middle letter (like "قَالَ").
 * - **ناقص**: Ends with a weak letter (like "رَمَى").
 * - **لفيف**: Contains two weak letters (e.g., لفيف مفروق، لفيف مقرون).
 *
 * @property id Unique identifier for the structure type.
 * @property arabicUnvoweled The structure name without vowel marks (e.g., "صحيح").
 * @property arabicVoweled The structure name with vowel marks (e.g., "صَحِيحٌ").
 */
@Serializable
data class StructureType(
    @SerialName("id") val id: Int, // Unique ID of the structure type.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String, // Name without tashkīl.
    @SerialName("arabic_voweled") val arabicVoweled: String, // Name with tashkīl.
)
