package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditBalance(
    @SerialName("account_id") val accountId: String,
    @SerialName("credits") val credits: Int,
    @SerialName("last_updated") val lastUpdated: Instant,
    @SerialName("last_payment_at") val lastPaymentAt: Instant? = null,
    @SerialName("updated_at") val updatedAt: Instant,
)
