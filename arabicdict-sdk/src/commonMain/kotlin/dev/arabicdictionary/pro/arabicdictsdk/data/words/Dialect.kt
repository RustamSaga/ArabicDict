package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a specific Arabic dialect used in different regions or countries.
 * This class is used to describe the linguistic variety in which a word or expression is used,
 * such as Egyptian Arabic, Levantine Arabic, Gulf Arabic, etc.
 *
 * @property id Unique identifier for the dialect.
 * @property name The commonly used name of the dialect (e.g., "Egyptian", "Levantine").
 * @property region The geographic or cultural region where the dialect is predominantly spoken (e.g., "Egypt", "Levant").
 * @property description A brief explanation or contextual note about the dialect, including linguistic or historical details.
 *
 * ### Example usage:
 * ```kotlin
 * val dialect = Dialect(
 *     id = 1,
 *     name = "Egyptian",
 *     region = "Egypt",
 *     description = "Most widely spoken variety in Egypt, characterized by its unique pronunciation and vocabulary."
 * )
 * ```
 */
@Serializable
data class Dialect(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("region") val region: String,
    @SerialName("description") val description: String,
)
