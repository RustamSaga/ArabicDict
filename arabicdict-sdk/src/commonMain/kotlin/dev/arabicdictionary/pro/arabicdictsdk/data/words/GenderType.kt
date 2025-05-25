package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing gender categories for pronouns in Arabic.
 * This class is used to represent different gender forms such as masculine, feminine, and both masculine and feminine.
 *
 * @property id The unique identifier for the gender type.
 * @property arabicVoweled The gender type in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The gender type in Arabic without vowel marks (diacritics).
 *
 * The gender categories are:
 * - **Masculine**: Refers to a single entity (e.g., "أنتَ" , "أنتم", "هم" , "هو").
 * - **Feminine**: Refers to two entities (e.g., "هنَّ" ,"هي" ,"أنتنَّ" ,"أنتِ").
 * - **Masculine and feminine**: Refers to more than two entities (e.g., "أنا", "هما", "أنتما", "نحن").
 *
 * ### Example usage:
 *
 * ```kotlin
 * // Masculine example
 * val masculine = GenderType(id = 1, arabicVoweled = "مذكر", arabicUnvoweled = "مذكر")
 *
 * // Feminine example
 * val feminine = GenderType(id = 2, arabicVoweled = "مؤنث", arabicUnvoweled = "مؤنث")
 *
 * // Masculine and Feminine example
 * val both = GenderType(id = 3, arabicVoweled = "مذكر ومؤنث", arabicUnvoweled = "مذكر ومؤنث")
 * ```
 */
@Serializable
data class GenderType(
    @SerialName("id") val id: Int, // The unique identifier for the gender type.
    @SerialName("arabic_voweled") val arabicVoweled: String, // The gender type in Arabic with vowel marks.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String, // The gender type in Arabic without vowel marks.
)
