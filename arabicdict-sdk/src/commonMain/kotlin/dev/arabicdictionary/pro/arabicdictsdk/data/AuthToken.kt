package dev.arabicdictionary.pro.arabicdictsdk.data

data class AuthToken(
    val accessToken: String,
    val refreshToken: String?,
    val expiresIn: Long
)
