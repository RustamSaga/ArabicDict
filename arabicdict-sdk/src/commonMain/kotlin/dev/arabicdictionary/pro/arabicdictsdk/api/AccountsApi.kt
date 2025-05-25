package dev.arabicdictionary.pro.arabicdictsdk.api

import de.jensklingenberg.ktorfit.http.GET
import dev.arabicdictionary.pro.arabicdictsdk.Response
import dev.arabicdictionary.pro.arabicdictsdk.data.Account
import dev.arabicdictionary.pro.arabicdictsdk.data.User

interface AccountsApi {
    @GET("me")
    suspend fun getCurrentUser(): Response<User>

    @GET("accounts")
    suspend fun getAccounts(): Response<List<Account>>
}
