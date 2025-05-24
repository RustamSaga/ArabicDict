package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing different morphological VERB patterns (أوزان) of a word in Arabic.
 * This class encapsulates both stem and lemma forms, with and without diacritical marks (tashkīl).
 *
 * @property diacriticalStem The stem form of the word with diacritics (جذر الكلمة بالتشكيل).
 * @property canonicalStem The stem form of the word without diacritics (جذر الكلمة بدون تشكيل).
 * @property diacriticalLemma The lemma form (dictionary base form) with diacritics (الصيغة المعجمية بالتشكيل).
 * @property canonicalLemma The lemma form without diacritics (الصيغة المعجمية بدون تشكيل).
 *
 * These patterns are used in morphological analysis to determine how a word is derived and classified.
 *
 * ### Example usage:
 * ```kotlin
 * val patterns = WordPatterns(
 *     diacriticalStem = WordPattern(
 *      id = 23,
 *      arabicVoweled = "فِعَّ",
 *      arabicUnvoweled = "فع",
 *      type = "DS",
 *      length = 2
 *     )
 * )
 * ```
 */
@Serializable
data class VerbWordPatterns(
    @SerialName("diacritical_stem") val diacriticalStem: VerbPattern, // جذر الكلمة بالتشكيل
    @SerialName("canonical_stem") val canonicalStem: VerbPattern,     // جذر الكلمة بدون تشكيل
    @SerialName("diacritical_lemma") val diacriticalLemma: VerbPattern, // الصيغة المعجمية بالتشكيل
    @SerialName("canonical_lemma") val canonicalLemma: VerbPattern      // الصيغة المعجمية بدون تشكيل
)
