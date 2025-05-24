package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the emphasis state (توكيد) of a verb in Arabic.
 * This class is used to specify whether a verb is in an emphatic (مؤكد) or non-emphatic (غير مؤكد) form.
 *
 * @property id The unique identifier for the emphasis type.
 * @property arabicVoweled The emphasis label in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The emphasis label in Arabic without vowel marks (diacritics).
 *
 * The emphasis categories are:
 * - **مؤكد (Emphatic)**: يُستخدم لتأكيد الفعل باستخدام نون التوكيد.
 *   - مثال: "لَيَكْتُبَنَّ"
 * - **غير مؤكد (Non-emphatic)**: الفعل يُستخدَم بدون نون التوكيد.
 *   - مثال: "يَكْتُبُ"
 *
 * ### Example usage:
 *
 * ```kotlin
 * // Emphatic verb
 * val emphatic = VerbEmphasis(id = 1, arabicVoweled = "مُؤَكَّدٌ", arabicUnvoweled = "مؤكد")
 *
 * // Non-emphatic verb
 * val nonEmphatic = VerbEmphasis(id = 2, arabicVoweled = "غَيْرُ مُؤَكَّدِ", arabicUnvoweled = "غير مؤكد")
 * ```
 */
@Serializable
data class VerbConfirmed(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String
)
