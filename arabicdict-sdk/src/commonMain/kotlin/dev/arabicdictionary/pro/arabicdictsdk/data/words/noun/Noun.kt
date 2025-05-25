package dev.arabicdictionary.pro.arabicdictsdk.data.words.noun

import dev.arabicdictionary.pro.arabicdictsdk.data.words.Meanings
import dev.arabicdictionary.pro.arabicdictsdk.data.words.Relations
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordDialect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a structured Arabic noun entry with its full linguistic and semantic metadata.
 *
 * This data class encapsulates information about a single noun, including its surface forms,
 * semantic meanings, morphological characteristics, grammatical variants, lexical relations,
 * and dialectal origin.
 *
 * ### Purpose:
 * Designed for use in linguistically rich Arabic dictionaries, educational tools, or NLP systems,
 * this class aggregates the full representation of a noun for display, analysis, or processing.
 *
 * @property id Unique identifier of the noun in the database or system.
 *
 * @property arabicVoweled The fully voweled (tashkeel) form of the Arabic word, e.g., "مُعَلِّم".
 *
 * @property arabicUnvoweled The unvoweled (bare) form of the Arabic word, e.g., "معلم".
 *
 * @property meaningsNumber Number of distinct semantic groups (definitions and translations)
 * associated with the noun.
 *
 * @property meanings A list of {@link Meanings} objects that represent definitions, translations,
 * semantic categories, and image URLs for visual context.
 *
 * @property nounMorphology An instance of {@link NounMorphology} describing the grammatical and structural features
 * of the noun, including its root, pattern(s), gender, number type, structure, and other relevant features.
 *
 * @property variants A {@link NounVariants} object describing different grammatical forms of the noun,
 * such as feminine/masculine, relative adjectives (النسب), wonder forms (التعجب), and diminutives (التصغير).
 *
 * @property relations A {@link Relations} object describing lexical relations such as synonyms and antonyms
 * for semantic network construction or lookup purposes.
 *
 * @property wordDialect A {@link WordDialect} object that records the dialectal variant of the noun,
 * including regional or colloquial forms and the dialect classification.
 *
 * ### Example:
 * ```kotlin
 *
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
 *
 * val noun = Noun(
 *     id = 42,
 *     arabicVoweled = "مُعَلِّم",
 *     arabicUnvoweled = "معلم",
 *     meaningsNumber = 2,
 *     meanings = listOf(meaning1, meaning2),
 *     nounMorphology = NounMorphology(
 *         wordType = "noun",
 *         root = "ع-ل-م",
 *         wordPatterns = listOf("فُعَلِّل"),
 *         structureType = "derived",
 *         originalWord = "علم",
 *         gender = "masculine",
 *         numberType = "singular",
 *         morphologicalFeatures = listOf("animate", "human")
 *     ),
 *     variants = nounVariants,
 *     relations = Relations(
 *         synonyms = listOf(WordId(101, "مُدَرِّس", "مدرس", ...)),
 *         antonyms = listOf(WordId(102, "جاهل", "جاهل", ...))
 *     ),
 *     wordDialect = WordDialect(
 *         id = 100,
 *         arabicVoweled = "مُعَلِّم",
 *         arabicUnvoweled = "معلم",
 *         dialect = Dialect("msa", "Modern Standard Arabic")
 *     )
 * )
 * ```
 */
@Serializable
data class Noun(
    @SerialName("id") val id: Int,
    @SerialName("arabic_voweled") val arabicVoweled: String,
    @SerialName("arabic_unvoweled") val arabicUnvoweled: String,
    @SerialName("meanings_number") val meaningsNumber: Int,
    @SerialName("meanings") val meanings: List<Meanings>,
    @SerialName("morphology") val nounMorphology: NounMorphology,
    @SerialName("variants") val variants: NounVariants,
    @SerialName("relations") val relations: Relations,
    @SerialName("word_dialect") val wordDialect: WordDialect,
)
