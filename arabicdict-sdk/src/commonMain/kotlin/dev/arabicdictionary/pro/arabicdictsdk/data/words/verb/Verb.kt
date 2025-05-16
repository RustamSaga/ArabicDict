package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.data.words.Category
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Meanings
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Relations
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Root
import dev.arabicdictionary.pro.arabicdictsdk.data.words.StructureType
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordId
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordPatterns
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an Arabic verb along with its morphological analysis, semantic meanings, and grammatical categories.
 *
 * This class is designed to capture detailed information about a verb in both its voweled and unvoweled forms,
 * its meanings across languages, and morphological characteristics such as root, pattern, tense, and transitivity.
 *
 * @property id Unique identifier for the verb.
 *
 * @property arabicVoweled The fully voweled (harakated) Arabic representation of the verb.
 *                         Example: "ذَهَبَ"
 *
 * @property arabicUnvoweled The unvoweled (bare) form of the verb.
 *                            Example: "ذهب"
 *
 * @property meaningsNumber The number of unique meaning entries associated with this verb.
 *
 * @property meanings A list of [Meanings] that provide definitions, translations, semantic categories,
 *                    and optionally images related to the verb in various contexts.
 *
 * @property categories A list of [Category] objects representing grammatical or semantic classifications,
 *                      such as "motion", "emotion", "causative", etc.
 *
 * @property verbMorphology An instance of [VerbMorphology] that provides detailed morphological
 *                          information about the type verb, including root, original, structure, conjugation,
 *                          grammaticalRoles.
 */
@Serializable
data class Verb(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("meaning_number") val meaningsNumber: Int,
    @SerialName("meanings") val meanings: List<Meanings>,
    @SerialName("categories") val categories: List<Category>,
    @SerialName("relations") val relations: Relations,
    @SerialName("verb_morphology") val verbMorphology: VerbMorphology,
)

