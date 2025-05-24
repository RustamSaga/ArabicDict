package dev.arabicdictionary.pro.arabicdictsdk.data.words.verb

import dev.arabicdictionary.pro.arabicdictsdk.data.words.ArabicGrammarCase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing a full verb conjugation in Arabic.
 * This class contains all grammatical components necessary to describe how a verb is conjugated
 * according to tense, voice, pronoun, emphasis, and grammatical case.
 *
 * @property id The unique identifier for the conjugation.
 * @property tense The tense (الزمن) of the verb, represented by [Tense], such as:
 * - **ماض**: Past tense
 * - **مضارع**: Present tense
 * - **أمر**: Imperative
 *
 * @property voice The verb voice (المبني للمعلوم / المبني للمجهول), represented by [VerbVoice], such as:
 * - **مبني للمعلوم**: Active voice
 * - **مبني للمجهول**: Passive voice
 *
 * @property pronoun The pronoun (الضمير) associated with this verb form, represented by [Pronoun], such as:
 * - "أنا", "نحن", "هو", "هم", etc.
 *
 * @property verbConfirmed The confirmed (التوكيد) applied to the verb, represented by [VerbConfirmed], such as:
 * - **غير مؤكد**: Non-confirmed
 * - **مؤكد**: Confirmed with "نون التوكيد"
 *
 * @property arabicGrammarCase The grammatical case (الإعراب) for the verb form, represented by [ArabicGrammarCase], such as:
 * - **مرفوع**: Indicative
 * - **منصوب**: Subjunctive
 * - **مجزوم**: Jussive
 *
 * ### Example usage:
 * ```kotlin
 * val conjugation = Conjugation(
 *     id = 1,
 *     tense = Tense(id = 1, arabicVoweled = "الْمَاضِي", arabicUnvoweled = "الماضي"),
 *     voice = VerbVoice(id = 1, arabicVoweled = "مَبْنِيٌّ لِلْمَعْلُومِ", arabicUnvoweled = "مبني للمعلوم"),
 *     pronoun = Pronoun(
 *         id = 1,
 *         arabicVoweled = "هُوَ",
 *         arabicUnvoweled = "هو",
 *         type = PronounType(3, "غَائِبٌ", "غائب"),
 *         numberType = NumberType(1, "مُفْرَدٌ", "مفرد"),
 *         genderType = GenderType(1, "مُذَكَّرٌ", "مذكر")
 *     ),
 *     verbConfirmed = VerbConfirmed(id = 1, arabicVoweled = "غَيْرُ مُؤَكَّدٍ", arabicUnvoweled = "غير مؤكد"),
 *     arabicGrammarCase = ArabicGrammarCase(id = 1, arabicVoweled = "مَرْفُوعٌ", arabicUnvoweled = "مرفوع")
 * )
 *
 *  // بحث الأمر المجهول
 * val conjugation = Conjugation(
 *     id = 1,
 *     tense = Tense(id = 3, arabicVoweled = "الأَمْرُ", arabicUnvoweled = "الأمر"),
 *     voice = VerbVoice(id = 2, arabicVoweled = "المَجْهُولُ", arabicUnvoweled = "المجهول"),
 *     pronoun = Pronoun(
 *         id = 1,
 *         arabicVoweled = "هُوَ",
 *         arabicUnvoweled = "هو",
 *         type = PronounType(3, "غَائِبٌ", "غائب"),
 *         numberType = NumberType(1, "مُفْرَدٌ", "مفرد"),
 *         genderType = GenderType(1, "مُذَكَّرٌ", "مذكر")
 *     ),
 *     verbConfirmed = VerbConfirmed(id = 1, arabicVoweled = "غَيْرُ مُؤَكَّدٍ", arabicUnvoweled = "غير مؤكد"),
 *     arabicGrammarCase = ArabicGrammarCase(id = 1, arabicVoweled = "مَجْزُومٌ", arabicUnvoweled = "مجزوم")
 * )
 *
 *
 * ```
 */

@Serializable
data class Conjugation(
    @SerialName("id") val id: Int, // Unique identifier for the conjugation.
    @SerialName("tense") val tense: Tense, // Tense of the verb (الماضي، المضارع، الأمر).
    @SerialName("voice") val voice: VerbVoice, // Verb voice (معلوم، مجهول).
    @SerialName("pronoun") val pronoun: Pronoun, // Associated pronoun.
    @SerialName("verb_confirmed") val verbConfirmed: VerbConfirmed, // Whether confirmed (نون التوكيد) is applied.
    @SerialName("arabic_grammar_case") val arabicGrammarCase: ArabicGrammarCase // Grammatical case (مرفوع، منصوب، مجزوم).
)
