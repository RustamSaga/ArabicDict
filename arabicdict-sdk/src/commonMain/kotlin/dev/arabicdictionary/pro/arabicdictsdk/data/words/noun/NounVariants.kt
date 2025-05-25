package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordNumberForms
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents various morphological variants of a noun in Arabic,
 * such as gender-based forms, relative adjectives (nisba), wonder expressions, and diminutives.
 *
 * Each variant consists of three number-based forms — singular, dual, and plural —
 * encapsulated in [WordNumberForms], where each form is a [WordId] with detailed word information.
 *
 * @property feminine Feminine versions of the noun in singular, dual, and plural forms.
 *                   Example: "مُعَلِّم" → "مُعَلِّمَة" (singular), "مُعَلِّمَتَانِ" (dual), "مُعَلِّمَات" (plural).
 *
 * @property masculine Masculine versions of the noun, especially relevant when the base is feminine.
 *                   Example: "مُعَلِّمَة" → "مُعَلِّم", "مُعَلِّمَانِ", "مُعَلِّمُونَ".
 *
 * @property relativeAdjectives Nisba (النسب) forms used to indicate relationship or affiliation.
 *                   Example: "مِصْر" → "مِصْرِيّ", "مِصْرِيَّانِ", "مِصْرِيُّونَ".
 *
 * @property wonder Wonder (التعجب) expressions used for exclamation or astonishment.
 *                  Example pattern: "ما أَفْعَلَهُ" (What a...!) or "أَفْعِلْ بِهِ".
 *
 * @property diminutive Diminutive (التصغير) forms that express smallness or endearment.
 *                  Example: "كِتَاب" → "كُتَيِّب", "كُتَيِّبَانِ", "كُتَيِّبَات".
 *
 * ### Example:
 * ```kotlin
 * val nounVariants = NounVariants(
 *     feminine = WordNumberForms(
 *         singular = WordId(1, "مُعَلِّمَة", "معلمة", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         dual = WordId(2, "مُعَلِّمَتَانِ", "معلمتان", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         plural = WordId(3, "مُعَلِّمَات", "معلمات", BaseWordType(1, "اِسْمٌ", "اسم"))
 *     ),
 *     masculine = WordNumberForms(
 *         singular = WordId(4, "مُعَلِّم", "معلم", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         dual = WordId(5, "مُعَلِّمَانِ", "معلمان", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         plural = WordId(6, "مُعَلِّمُونَ", "معلمون", BaseWordType(1, "اِسْمٌ", "اسم"))
 *     ),
 *     relativeAdjectives = WordNumberForms(
 *         singular = WordId(7, "مِصْرِيّ", "مصري", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         dual = WordId(8, "مِصْرِيَّانِ", "مصريان", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         plural = WordId(9, "مِصْرِيُّونَ", "مصريون", BaseWordType(1, "اِسْمٌ", "اسم"))
 *     ),
 *     wonder = WordNumberForms(
 *         singular = WordId(10, "ما أَجْمَلَهُ", "ما اجمله", BaseWordType(2, "فِعْلٌ", "فعل")),
 *         dual = WordId(11, "", "", BaseWordType(2, "فِعْلٌ", "فعل")),
 *         plural = WordId(12, "", "", BaseWordType(2, "فِعْلٌ", "فعل"))
 *     ),
 *     diminutive = WordNumberForms(
 *         singular = WordId(13, "كُتَيِّب", "كتَيّب", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         dual = WordId(14, "كُتَيِّبَانِ", "كتَيّبان", BaseWordType(1, "اِسْمٌ", "اسم")),
 *         plural = WordId(15, "كُتَيِّبَات", "كتَيّبات", BaseWordType(1, "اِسْمٌ", "اسم"))
 *     )
 * )
 * ```
 */

@Serializable
data class NounVariants(
    @SerialName("feminine") val feminine: WordNumberForms,
    @SerialName("masculine") val masculine: WordNumberForms,
    @SerialName("relative_adjectives") val relativeAdjectives: WordNumberForms, // النسب
    @SerialName("wonder") val wonder: WordNumberForms, // التعجب
    @SerialName("diminutive") val diminutive: WordNumberForms, //  التصغير
)
