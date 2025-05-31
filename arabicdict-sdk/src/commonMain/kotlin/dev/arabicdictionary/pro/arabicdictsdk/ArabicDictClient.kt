package dev.arabicdictionary.pro.arabicdictsdk

import de.jensklingenberg.ktorfit.Ktorfit
import dev.arabicdictionary.pro.arabicdictsdk.api.AccountsApi
import dev.arabicdictionary.pro.arabicdictsdk.api.AuthApi
import dev.arabicdictionary.pro.arabicdictsdk.api.DictionaryApi
import dev.arabicdictionary.pro.arabicdictsdk.data.DeveloperToken
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.DefaultJson
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.ClassDiscriminatorMode
import kotlinx.serialization.json.Json

class ArabicDictClient internal constructor(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {
    @Suppress("ktlint:standard:chain-method-continuation")
    private val ktorfit by lazy {
        Ktorfit.Builder()
            .httpClient(httpClient)
            .converterFactories(ResponseConverterFactory())
            .baseUrl(baseUrl)
            .build()
    }

    @Suppress("DEPRECATION")
    val accounts by lazy { ktorfit.create<AccountsApi>() }

    @Suppress("DEPRECATION")
    val dictionary by lazy { ktorfit.create<DictionaryApi>() }

//    @Suppress("DEPRECATION")
//    val subscription by lazy { ktorfit.create<SubscriptionApi>() }

    @Suppress("DEPRECATION")
    val auth by lazy { ktorfit.create<AuthApi>() }

    companion object {
        public const val API_BASE_URL = "https://api.frame.io/v2/"
    }
}

fun ArabicDictClient(
    developerToken: DeveloperToken,
    baseUrl: String = ArabicDictClient.API_BASE_URL,
    json: Json = DefaultJson,
): ArabicDictClient {
    val httpClient = arabicdictHttpClient(developerToken, json)
    return ArabicDictClient(baseUrl, httpClient)
}

suspend fun validateArabicdictDeveloperToken(
    developerToken: DeveloperToken,
    baseUrl: String = ArabicDictClient.API_BASE_URL,
    json: Json = DefaultJson,
): Response<Unit> {
    val httpClient = arabicdictHttpClient(developerToken, json)
    return ArabicDictClient(baseUrl, httpClient).auth.isValid()
}

private fun arabicdictHttpClient(
    developerToken: DeveloperToken,
    json: Json? = null,
): HttpClient =
    HttpClient {
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(accessToken = developerToken.token, refreshToken = null)
                }
            }
        }

        if (json != null) {
            install(ContentNegotiation) {
                json(jsonForArabicdict(json))
            }
        }
    }

private fun jsonForArabicdict(baseJson: Json): Json =
    Json(from = baseJson) {
        ignoreUnknownKeys = true
        classDiscriminator = "_type"
        classDiscriminatorMode = ClassDiscriminatorMode.POLYMORPHIC
    }
