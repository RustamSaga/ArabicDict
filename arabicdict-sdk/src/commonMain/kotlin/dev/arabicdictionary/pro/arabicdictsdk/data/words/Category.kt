package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a classification category associated with a word.
 * Categories help in grouping or tagging words based on their grammatical, semantic, or thematic properties.
 *
 * @property id Unique identifier of the category.
 *              This is typically used to reference or fetch the category programmatically.
 *
 * @property name The short or display name of the category.
 *                For example: `"Verb"`, `"Color"`, `"Animal"`, `"Abstract Noun"`.
 *
 * @property description A longer explanation describing the nature, purpose, or characteristics of the category.
 *                       This can be useful for UI displays or language learners.
 *
 * ### Example:
 * ```kotlin
 * val category = Category(
 *     id = 5,
 *     name = "Emotion",
 *     description = "Words that describe feelings or emotional states."
 * )
 * ```
 *
 * This category could be used to tag words like "happiness", "fear", or "anger".
 */

@Serializable
data class Category(
    @SerialName("id") val id: Int, // Unique identifier of the category.
    @SerialName("name") val name: String, // Name of the category (e.g., "Verb").
    @SerialName("description") val description: String // Description or explanation of the category.
)

