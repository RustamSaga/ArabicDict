package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.serialization.Serializable

@Serializable
data class ArabicApiError internal constructor(
    val code: Int,
    val message: String? = null,
    val errors: List<Error>? = null,
) {
    @Serializable
    class Error internal constructor(
        val code: Int,
        val status: Int,
        val title: String? = null,
        val detail: String? = null,
    )
}
