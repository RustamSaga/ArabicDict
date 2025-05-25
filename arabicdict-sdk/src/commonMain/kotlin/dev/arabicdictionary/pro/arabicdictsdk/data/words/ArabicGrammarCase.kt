package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing an Arabic grammatical case (الإعراب).
 * This class is used to describe the syntactic function or grammatical state of a word,
 * such as nominative (مرفوع), accusative (منصوب), genitive (مجرور), or jussive (مجزوم).
 *
 * @property id The unique identifier for the grammatical case.
 * @property arabicVoweled The case name in Arabic with vowel marks (diacritics).
 * @property arabicUnvoweled The case name in Arabic without vowel marks (diacritics).
 *
 * The grammatical cases are:
 * - **مرفوع**: يُستخدم للفاعل، وللمبتدأ والخبر، وفي المضارع المرفوع.
 *   - مثال: "الولدُ يكتبُ"
 * - **منصوب**: يُستخدم للمفعول به، والأسماء بعد إنّ، وفي المضارع المنصوب.
 *   - مثال: "لن يذهبَ"
 * - **مجرور**: يُستخدم بعد حروف الجرّ أو في المضاف إليه.
 *   - مثال: "في المدرسةِ"
 * - **مجزوم**: يُستخدم في الأفعال المضارعة بعد أدوات الجزم.
 *   - مثال: "لم يذهبْ"
 *
 * ### Example usage:
 *
 * ```kotlin
 * val nominative = ArabicGrammarCase(id = 1, arabicVoweled = "مَرْفُوعٌ", arabicUnvoweled = "مرفوع")
 * val accusative = ArabicGrammarCase(id = 2, arabicVoweled = "مَنْصُوبٌ", arabicUnvoweled = "منصوب")
 * val genitive = ArabicGrammarCase(id = 3, arabicVoweled = "مَجْرُورٌ", arabicUnvoweled = "مجرور")
 * val jussive = ArabicGrammarCase(id = 4, arabicVoweled = "مَجْزُومٌ", arabicUnvoweled = "مجزوم")
 * ```
 */
@Serializable
data class ArabicGrammarCase(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
)
