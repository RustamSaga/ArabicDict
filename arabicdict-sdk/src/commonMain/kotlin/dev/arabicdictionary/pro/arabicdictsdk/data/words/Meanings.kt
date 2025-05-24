package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Represents the semantic content of a word, including its definitions, translations,
 * and associated semantic categories.
 *
 * This class is used to group all meaningful interpretations of a word across multiple languages and contexts.
 *
 * @property id Unique identifier for this meaning group.
 * @property definition A list of definitions in Arabic, each optionally translated into a specified target language.
 *                      Each definition includes its source, meaning in Arabic, and translation.
 * @property translation A list of additional translations for the word, which may or may not correspond directly
 *                        to the definitions. Useful for simple dictionary lookup or multilingual use cases.
 * @property categories A list of categories classifying the word's semantic or grammatical role
 *                      (e.g., "action", "emotion", "abstract noun").
 *
 * ### Example:
 * ```kotlin
 * val meaning = Meanings(
 *     id = 1001,
 *     definition = listOf(
 *         Definition(
 *             sourceName = "لسان العرب",
 *             id = 1,
 *             arabicWordId = 500,
 *             definition = "هو انتقال الشخص من مكان إلى آخر",
 *             translation = "The act of moving from one place to another",
 *             language = "en"
 *         )
 *     ),
 *     translation = listOf(
 *         Translation(
 *             arabicWordId = 500,
 *             translationWordId = 2001,
 *             translate = "travel",
 *             language = "en",
 *             meaningId = 1001
 *         )
 *     ),
 *     categories = listOf(
 *         Category(
 *             id = 1,
 *             name = "Motion",
 *             description = "Refers to actions involving physical movement"
 *         )
 *     )
 * )
 * ```
 */

@Serializable
data class Meanings(
    @SerialName("id") val id: Int,
    @SerialName("definition") val definition: List<Definition>,
    @SerialName("translation") val translation: List<Translation>,
    @SerialName("image_url") val imagesUrl: List<String>,
    @SerialName("categories") val categories: List<Category> // Categories describing the word's role or type.
)
