package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.utils.TenseSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Data class representing a verb tense category in Arabic.
 * This class is used to distinguish between different verb tenses such as the past, present, imperative, and emphatic (توكيد).
 *
 * @property id The unique identifier for the tense.
 * @property arabicVoweled The tense name in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The tense name in Arabic without vowel marks (diacritics).
 *
 * The tense categories are:
 * - **الماضي (Past tense)**: يُستخدم للتعبير عن حدث وقع في الزمن الماضي.
 *   - مثال: "كَتَبَ"
 * - **المضارع (Present tense)**: يُستخدم للتعبير عن حدث يقع في الحاضر أو المستقبل.
 *   - مثال: "يَكْتُبُ"
 * - **الأمر (Imperative)**: يُستخدم لإعطاء أمر أو طلب.
 *   - مثال: "اُكْتُبْ"

 * ### Example usage:
 *
 * ```kotlin
 * // Past tense
 * val past = Tense(id = 1, arabicVoweled = "مَاضٍ", arabicUnvoweled = "ماض")
 *
 * // Present tense
 * val present = Tense(id = 2, arabicVoweled = "مُضَارِعٌ", arabicUnvoweled = "مضارع")
 *
 * // Imperative tense
 * val imperative = Tense(id = 3, arabicVoweled = "أَمْرٌ", arabicUnvoweled = "أمر")
 *
 */
@Serializable
data class Tense(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String
)
