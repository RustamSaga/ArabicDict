package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a single grammatical form of an Arabic verb.
 *
 * In Arabic morphology, verbs can exist in the following forms:
 * 1. الماضي (mādī) — past tense, for example: "كَتَبَ" (he wrote)
 * 2. المضارع (muḍāriʿ) — present/future tense, for example: "يَكْتُبُ" (he writes)
 * 3. الأمر (ʾamr) — imperative mood, for example: "اُكْتُبْ" (write!)
 * 4. التوكيد (tawkīd) — emphatic form with the particles "لَ" and "نَّ", for example: "لَيَكْتُبَنَّ"
 *
 * This class describes a single verb form with its voweled and unvoweled versions.
 *
 * @property id Unique identifier for the verb form.
 * @property arabicVoweled The voweled form of the verb (with diacritics).
 * @property arabicUnvoweled The unvoweled form of the verb (without diacritics).
 *
 * Example:
 * val verbForm = ArabicVerbForm(
 *     id = 1,
 *     arabicVoweled = "يَكْتُبُ",
 *     arabicUnvoweled = "يكتب"
 * )
 */
@Serializable
data class ArabicVerbForm(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String
)
