package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing various morphological features of a noun or word in Arabic.
 *
 * @property isAnimate Indicates whether the word refers to an animate being.
 * @property canHaveTanween Indicates whether the word can take tanween (nunation).
 * @property canHavePlural Indicates whether the word can be pluralized.
 * @property canHaveQualitativeAdjectives Indicates whether qualitative adjectives can be applied.
 * @property canHaveRelativeAdjectives Indicates whether relative adjectives (nisba) can be applied.
 */
@Serializable
data class NounMorphologicalFeatures(
    @SerialName("is_animate") val isAnimate: Boolean,
    @SerialName("can_have_tanween") val canHaveTanween: Boolean,
    @SerialName("can_have_plural") val canHavePlural: Boolean,
    @SerialName("can_have_qualitative_adjectives") val canHaveQualitativeAdjectives: Boolean,
    @SerialName("can_have_relative_adjectives") val canHaveRelativeAdjectives: Boolean,
)
