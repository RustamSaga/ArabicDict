package dev.arabicdictionary.pro.arabicdictsdk.api

import de.jensklingenberg.ktorfit.http.HEAD
import dev.arabicdictionary.pro.arabicdictsdk.Response

interface AuthApi {
    @HEAD("me")
    suspend fun isValid(): Response<Unit>
}
//
//interface AuthApi {
//    @POST("auth/login")
//    suspend fun login(@Body body: LoginRequest): AuthResponse
//
//    @POST("auth/register")
//    suspend fun register(@Body body: RegisterRequest): AuthResponse
//}
