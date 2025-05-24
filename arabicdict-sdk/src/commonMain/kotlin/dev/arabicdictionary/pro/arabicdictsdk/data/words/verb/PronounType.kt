package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Data class representing a pronoun category in Arabic.
 * This class is used to represent different types of pronouns in Arabic, such as first-person (متكلم), second-person (مخاطب), and third-person (غائب).
 *
 * @property id The unique identifier for the pronoun type.
 * @property arabicVoweled The pronoun type in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The pronoun type in Arabic without vowel marks (diacritics).
 *
 ** The pronoun categories are:
 *  * - **متكلم (First-person)**: Refers to the speaker.
 *  *   - Singular (أنا) — "I"
 *  *   - Plural (نحن) — "We"
 *  *
 *  * - **مخاطب (Second-person)**: Refers to the listener.
 *  *   - Singular Masculine (أنتَ) — "You" (masculine singular)
 *  *   - Singular Feminine (أنتِ) — "You" (feminine singular)
 *  *   - Dual Masculine (أنتما) — "You two" (masculine)
 *  *   - Dual Feminine (أنتما) — "You two" (feminine)
 *  *   - Plural Masculine (أنتم) — "You all" (masculine plural)
 *  *   - Plural Feminine (أنتنَّ) — "You all" (feminine plural)
 *  *
 *  * - **غائب (Third-person)**: Refers to someone else.
 *  *   - Singular Masculine (هو) — "He"
 *  *   - Singular Feminine (هي) — "She"
 *  *   - Dual Masculine (هما) — "They two" (masculine)
 *  *   - Dual Feminine (هما) — "They two" (feminine)
 *  *   - Plural Masculine (هم) — "They" (masculine plural)
 *  *   - Plural Feminine (هنَّ) — "They" (feminine plural)
 *  *
 * ### Example usage:
 *
 * ```kotlin
 * // First-person example (متكلم)
 * val firstPerson = PronounType(id = 1, arabicVoweled = "مُتَكَلِّمٌ", arabicUnvoweled = "متكلم")
 *
 * // Second-person example (مخاطب)
 * val secondPerson = PronounType(id = 2, arabicVoweled = "مُخَاطَبٌ", arabicUnvoweled = "مخاطب")
 *
 * // Third-person example (غائب)
 * val thirdPerson = PronounType(id = 3, arabicVoweled = "غَائِبٌ", arabicUnvoweled = "غائب")
 * ```
 */
@Serializable
data class PronounType(
    @SerialName("id") val id: Int, // The unique identifier for the pronoun type.
    @SerialName("arabic_voweled") val arabicVoweled: String, // The pronoun type in Arabic with vowel marks.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String // The pronoun type in Arabic without vowel marks.
)
