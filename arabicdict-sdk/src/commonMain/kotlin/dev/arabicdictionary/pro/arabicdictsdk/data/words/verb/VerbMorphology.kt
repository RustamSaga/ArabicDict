package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.data.words.Root
import dev.arabicdictionary.pro.arabicdictsdk.data.words.StructureType
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordId
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordPatterns
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the **morphological structure** and grammatical behavior of an Arabic verb.
 *
 * This includes the root, pattern, structure type, original/base form, and full conjugation.
 * It is a reusable component for any [Verb] entity, isolating the verb-specific morphological data.
 *
 * @property root The [Root] of the verb (usually triliteral or quadriliteral).
 * @property wordPatterns The derived morphological pattern(s) ([WordPatterns]) of the verb.
 * @property structureType The phonological structure of the verb (e.g., صحيح, مهموز).
 * @property original The base or original form of the verb, as a [WordId].
 * @property baseFormNumber Indicates the base form number (e.g., Form I, II, III...).
 * @property conjugation The full [Conjugation] data for the verb (tense, voice, pronoun, etc.).
 * @property grammaticalRoles The possible [VerbGrammaticalRoles] the verb can occupy in syntax (e.g., subject, object).
 */
@Serializable
data class VerbMorphology(
    @SerialName("word_type") val wordType: WordType,
    @SerialName("root") val root: Root,
    @SerialName("word_patterns") val wordPatterns: WordPatterns,
    @SerialName("structure_type") val structureType: StructureType,
    @SerialName("original") val original: WordId,
    @SerialName("base_form_number") val baseFormNumber: Int,
    @SerialName("conjugation") val conjugation: Conjugation,
    @SerialName("grammatical_roles") val grammaticalRoles: VerbGrammaticalRoles
)
