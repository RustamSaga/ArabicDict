package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import dev.arabicdictionary.pro.arabicdictsdk.data.words.GenderType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
/**
 * Data class representing the grammatical and semantic gender of a noun in Arabic.
 *
 * This class includes both the grammatical gender (masculine, feminine, etc.) and its subtype:
 * real (حقيقي), metaphorical (مجازي), or both (مُذَكَّرُ والمُؤَنَّثُ).
 *
 * @property id The unique identifier for the record.
 * @property voweledGenderSubtype The gender subtype with diacritics, e.g., "المُذَكَّرُ الحَقِيقِي".
 * @property unvoweledGenderSubtype The gender subtype without diacritics, e.g., "المذكر الحقيقي".
 * @property genderType The main gender type: masculine, feminine, or both ([GenderType]).
 *
 * ### Example:
 * ```kotlin
 * val nounGender = NounGender(
 *     id = 1,
 *     voweledGenderSubtype = "المُذَكَّرُ الحَقِيقِي",
 *     unvoweledGenderSubtype = "المذكر الحقيقي",
 *     genderType = GenderType(id = 1, arabicVoweled = "مذكر", arabicUnvoweled = "مذكر")
 * )
 * ```
 */
@Serializable
data class NounGender(
    @SerialName("id") val id: Int,
    @SerialName("voweled_gender_subtype") val voweledGenderSubtype: String,
    @SerialName("unvoweled_gender_subtype") val unvoweledGenderSubtype: String,
    @SerialName("gender_type") val genderType: GenderType,
)


