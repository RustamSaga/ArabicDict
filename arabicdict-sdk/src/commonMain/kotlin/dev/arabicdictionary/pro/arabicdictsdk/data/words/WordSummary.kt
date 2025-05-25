package dev.arabicdictionary.pro.arabicdictsdk.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WordSummary(
    @SerialName("id") val id: Int,
    @SerialName("arabic_word") val arabicWord: String,
    @SerialName("meanings_number") val meaningsNumber: Int,
    @SerialName("translations") val translations: List<String>,
    @SerialName("word_types") val wordTypes: List<WordType>,
    @SerialName("categories") val categories: List<Category>,
    @SerialName("image_url") val imageUrl: String? = null,
)
