package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.data.words.GenderType
import dev.arabicdictionary.pro.arabicdictsdk.data.words.NumberType
import dev.arabicdictionary.pro.arabicdictsdk.utils.PronounSerializer
import kotlinx.serialization.Serializable


/**
 * Data class representing an Arabic pronoun with grammatical attributes.
 * This class is used for serializing and deserializing pronoun data including its Arabic forms, grammatical person,
 * number, and gender.
 *
 * @property id The unique identifier for the pronoun.
 * @property arabicVoweled The pronoun in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The pronoun in Arabic without vowel marks (diacritics).
 * @property type The grammatical person (الضمير) of the pronoun, represented by [PronounType]:
 * - **متكلم**: First person (e.g., "أنا", "نحن")
 * - **مخاطب**: Second person (e.g., "أنتَ", "أنتِ", "أنتم")
 * - **غائب**: Third person (e.g., "هو", "هي", "هم")
 *
 * @property numberType The number category (العدد) of the pronoun, represented by [NumberType]:
 * - **مفرد**: Singular (e.g., "هو", "أنا")
 * - **مثنى**: Dual (e.g., "هما", "أنتما")
 * - **جمع**: Plural (e.g., "هم", "نحن")
 *
 * @property genderType The gender (الجنس) of the pronoun, represented by [GenderType]:
 * - **مذكر**: Masculine (e.g., "هو", "أنتَ")
 * - **مؤنث**: Feminine (e.g., "هي", "أنتِ")
 * - **مذكر ومؤنث**: Masculine and Feminine (e.g., "نحن", "أنتم")
 *
 * ### Example usage:
 *
 * ```kotlin
 * val example = Pronoun(
 *     id = 1,
 *     arabicVoweled = "هُوَ",
 *     arabicUnvoweled = "هو",
 *     type = PronounType(id = 3, arabicVoweled = "غَائِبٌ", arabicUnvoweled = "غائب"),
 *     numberType = NumberType(id = 1, arabicVoweled = "مُفْرَدٌ", arabicUnvoweled = "مفرد"),
 *     genderType = GenderType(id = 1, arabicVoweled = "مُذَكَّرٌ", arabicUnvoweled = "مذكر")
 * )
 * ```
 */
@Serializable
data class Pronoun(
    val id: Int, // The unique identifier of the pronoun.
    val arabicVoweled: String, // The pronoun with vowel marks (diacritics).
    val arabicUnvoweled: String, // The pronoun without vowel marks (diacritics).
    val type: PronounType, // The grammatical person (متكلم، مخاطب، غائب).
    val numberType: NumberType, // The number category (مفرد، مثنى، جمع).
    val genderType: GenderType // The gender category (مذكر، مؤنث، مذكر ومؤنث).
)


