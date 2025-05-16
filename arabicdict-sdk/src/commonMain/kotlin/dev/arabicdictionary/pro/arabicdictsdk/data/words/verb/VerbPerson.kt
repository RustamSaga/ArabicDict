package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a single grammatical person form of an Arabic verb.
 *
 * In Arabic conjugation, verbs are inflected according to person (1st, 2nd, 3rd person),
 * gender (masculine, feminine), and number (singular, plural, dual). This class stores
 * a single form of the verb based on the grammatical person with both voweled and unvoweled versions.
 *
 * @property id Unique identifier for the verb person form.
 * @property arabicVoweled The voweled form of the verb for the specific person (with diacritics).
 * @property arabicUnvoweled The unvoweled form of the verb for the specific person (without diacritics).
 *
 * Example:
 * val verbPerson = VerbPerson(
 *     id = 1,
 *     arabicVoweled = "أَكْتُبُ",
 *     arabicUnvoweled = "اكتب"
 * )
 */
@Serializable
data class VerbPerson(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String
)
