package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import dev.arabicdictionary.pro.arabicdictsdk.data.words.NumberType
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Root
import dev.arabicdictionary.pro.arabicdictsdk.data.words.StructureType
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordId
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordPatterns
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the morphological properties of a noun.
 */
@Serializable
data class NounMorphology(
    @SerialName("word_types") val wordTypes: List<WordType>,
    @SerialName("root") val root: Root,
    @SerialName("word_patterns") val wordPatterns: WordPatterns,
    @SerialName("structure_type") val structureType: StructureType,
    @SerialName("original") val original: WordId,
    @SerialName("gender") val gender: NounGender,
    @SerialName("number_type") val numberType: NumberType,
    @SerialName("morphological_features") val morphologicalFeatures: NounMorphologicalFeatures,
)
