package dev.arabicdictionary.pro.arabicdictsdk

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.DefaultJson
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ArabicDictClient(
    private val httpClient: HttpClient
) {

    val assets = AssetsApi(httpClient)
}

private fun defaultHttpClient(
    baseUrl: String = "https://your/base/url",
    json: Json = DefaultJson
): HttpClient {
    return HttpClient {
        install(DefaultRequest) {
            url(baseUrl)
        }

        install(ContentNegotiation) {
            json(json)
        }
    }
}