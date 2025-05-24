package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    @SerialName("id") val id: String,
    @SerialName("type") val type: AccountType,
    @SerialName("status") val status: String,
    @SerialName("created_at") val createdAt: String, // ISO 8601
    @SerialName("expires_at") val expiresAt: String?, // Nullable for lifetime access
    @SerialName("is_active") val isActive: Boolean
)

@Serializable
enum class AccountType {
    @SerialName("free") FREE,
    @SerialName("premium") PREMIUM,
    @SerialName("gpt_plus") GPT_PLUS
}
