package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class User(
    @SerialName("id") val id: String,
    @SerialName("email") val email: String,
    @SerialName("name") val name: String,
    @SerialName("avatar_url") val avatarUrl: String?,
    @SerialName("registered_at") val registeredAt: String, // ISO 8601

    @SerialName("native_language") val nativeLanguage: String,
    @SerialName("vocabulary_size") val vocabularySize: Int = 0,
    @SerialName("daily_goal") val dailyGoal: Int = 10,
    @SerialName("learning_streak") val learningStreak: Int = 0,
    @SerialName("last_activity") val lastActivity: String?, // ISO 8601

    @SerialName("has_purchased_database") val hasPurchasedDatabase: Boolean = false,
    @SerialName("gpt_subscription") val gptSubscription: GptSubscription?
)

@Serializable
data class GptSubscription(
    @SerialName("subscribed") val subscribed: Boolean,
    @SerialName("start_date") val startDate: String?,
    @SerialName("end_date") val endDate: String?,
    @SerialName("tier") val tier: GptTier
)

@Serializable
enum class GptTier {
    @SerialName("basic") BASIC,
    @SerialName("pro") PRO,
    @SerialName("enterprise") ENTERPRISE
}
