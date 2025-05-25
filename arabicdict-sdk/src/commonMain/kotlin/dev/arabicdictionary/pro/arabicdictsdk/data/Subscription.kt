package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subscription(
    @SerialName("id") val id: String,
    @SerialName("account_id") val accountId: String,
    @SerialName("started_at") val startedAt: Instant,
    @SerialName("expires_at") val expiresAt: Instant,
    @SerialName("next_billing_at") val nextBillingAt: Instant? = null,
    @SerialName("last_payment_at") val lastPaymentAt: Instant? = null,
    @SerialName("on_trial") val onTrial: Boolean = false,
    @SerialName("cancelled_at") val cancelledAt: Instant? = null,
    @SerialName("cancellation_reason") val cancellationReason: String? = null,
    @SerialName("storage_limit") val storageLimit: Long? = null,
    @SerialName("updated_at") val updatedAt: Instant,
)
