package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the **grammatical roles** (الوظائف النحوية) associated with a word in Arabic.
 *
 * This class models the syntactic functions that a word may fulfill within a sentence,
 * such as acting as a subject, object, superlative form, instrument noun, or adverbial noun.
 *
 * All properties are optional (`null` by default) since not every word has all these roles.
 *
 * @property subject The word used as the **subject** (الفاعل) — the doer of the action.
 * @property obj The word used as the **object** (المفعول) — the receiver of the action.
 * @property superlative The word representing a **superlative form** (اسم التفضيل) — e.g., "أَكْبَر", "أَفْضَل".
 * @property instrument The word used as an **instrument noun** (اسم الآلة) — a tool used to perform the action (e.g., "مِفْتَاح").
 * @property adverbial The word used as a **noun of adverbial meaning** (اسم الظرف) — indicating time or place (e.g., "أمام", "فوق", "غدًا").
 *
 * ### Example usage:
 * ```kotlin
 * val roles = GrammaticalRoles(
 *     subject = WordId(
 *         id = 101,
 *         arabicVoweled = "الطَّالِبُ",
 *         arabicUnvoweled = "الطالب",
 *         baseWordType = BaseWordType(1, "اِسْمٌ", "اسم")
 *     ),
 *     obj = WordId(
 *         id = 102,
 *         arabicVoweled = "الكِتَابَ",
 *         arabicUnvoweled = "الكتاب",
 *         baseWordType = BaseWordType(1, "اِسْمٌ", "اسم")
 *     ),
 *     superlative = WordId(
 *         id = 103,
 *         arabicVoweled = "أَسْرَعُ",
 *         arabicUnvoweled = "اسرع",
 *         baseWordType = BaseWordType(1, "اِسْمٌ", "اسم")
 *     ),
 *     instrument = WordId(
 *         id = 104,
 *         arabicVoweled = "مِكْنَسَةٌ",
 *         arabicUnvoweled = "مكنسة",
 *         baseWordType = BaseWordType(1, "اِسْمٌ", "اسم")
 *     ),
 *     adverbial = WordId(
 *         id = 105,
 *         arabicVoweled = "فَوْقَ",
 *         arabicUnvoweled = "فوق",
 *         baseWordType = BaseWordType(1, "اِسْمٌ", "اسم")
 *     )
 * )
 * ```
 */
@Serializable
data class VerbGrammaticalRoles(
    @SerialName("subject") val subject: WordId? = null,            // الفاعل
    @SerialName("object") val obj: WordId? = null,                 // المفعول
    @SerialName("superlative") val superlative: WordId? = null,   // اسم التفضيل
    @SerialName("instrument") val instrument: WordId? = null,     // اسم الآلة
    @SerialName("adverbial") val adverbial: WordId? = null,        // اسم الظرف
    @SerialName("transitivity") val transitivity: WordId? = null        // الصيرورة
)
