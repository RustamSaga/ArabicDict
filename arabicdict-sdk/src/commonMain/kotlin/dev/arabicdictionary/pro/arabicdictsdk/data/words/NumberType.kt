package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a grammatical number category in Arabic (العدد).
 *
 * This class is used to distinguish between singular, dual, plural, and universal (generic) forms,
 * particularly in the context of pronouns, nouns, and verb conjugations.
 *
 * @property id The unique identifier for the number type.
 * @property arabicVoweled The number type in Arabic with diacritical marks (tashkīl), e.g., "مُفْرَدٌ".
 * @property arabicUnvoweled The number type in Arabic without diacritical marks, e.g., "مفرد".
 *
 * ### Number categories:
 * - **Singular (مُفْرَدٌ)**: Refers to a single entity.
 *   - Examples: "أنا", "أنتَ", "أنتِ", "هو", "هي"
 *
 * - **Dual (مُثَنَّى)**: Refers specifically to two entities.
 *   - Examples: "أنتما", "هما"
 *
 * - **Plural (جَمْعٌ)**: Refers to more than two entities.
 *   - Examples: "نحن", "أنتم", "أنتنَّ", "هم", "هنَّ"
 *
 * - **Universal (عامّ)**: Used when the number form is general or not specified (e.g., in templates or generic rules).
 *
 * ### Example usage:
 * ```kotlin
 * // Singular
 * val singular = NumberType(id = 1, arabicVoweled = "مُفْرَدٌ", arabicUnvoweled = "مفرد")
 *
 * // Dual
 * val dual = NumberType(id = 2, arabicVoweled = "مُثَنَّى", arabicUnvoweled = "مثنى")
 *
 * // Plural
 * val plural = NumberType(id = 3, arabicVoweled = "جَمْعٌ", arabicUnvoweled = "جمع")
 *
 * // Universal or general-purpose
 * val universal = NumberType(id = 4, arabicVoweled = "عَامّ", arabicUnvoweled = "عام")
 * ```
 */

@Serializable
data class NumberType(
    @SerialName("id") val id: Int, // The unique identifier for the number type.
    @SerialName("arabic_voweled") val arabicVoweled: String, // The number type in Arabic with vowel marks.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String, // The number type in Arabic without vowel marks.
)
