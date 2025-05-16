package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a verb voice category in Arabic.
 * This class is used to distinguish between different verb voices such as the active and passive voice.
 *
 * @property id The unique identifier for the verb voice.
 * @property arabicVoweled The verb voice name in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The verb voice name in Arabic without vowel marks (diacritics).
 *
 * The verb voice categories are:
 * - **معلوم (Active voice)**: Indicates that the subject performs the action.
 *   - مثال: "كَتَبَ الوَلَدُ الدَّرسَ" (The boy wrote the lesson)
 * - **مجهول (Passive voice)**: Indicates that the action is performed on the subject.
 *   - مثال: "كُتِبَ الدَّرسُ" (The lesson was written)
 *
 * ### Example usage:
 *
 * ```kotlin
 * // Active voice example
 * val activeVoice = VerbVoice(id = 1, arabicVoweled = "مَعْلُومٌ", arabicUnvoweled = "معلوم")
 *
 * // Passive voice example
 * val passiveVoice = VerbVoice(id = 2, arabicVoweled = "مَجْهُولٌ", arabicUnvoweled = "مجهول")
 * ```
 */
@Serializable
data class VerbVoice(
    @SerialName("id") val id: Int, // The unique identifier for the verb voice.
    @SerialName("arabic_voweled") val arabicVoweled: String, // The verb voice in Arabic with vowel marks.
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String // The verb voice in Arabic without vowel marks.
)
