package dev.arabicdictionary.pro.arabicdictsdk.api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import de.jensklingenberg.ktorfit.http.QueryMap
import dev.arabicdictionary.pro.arabicdictsdk.Response
import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordSummary
import dev.arabicdictionary.pro.arabicdictsdk.data.words.noun.Noun
import dev.arabicdictionary.pro.arabicdictsdk.data.words.particle.Particle
import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.Verb

interface DictionaryApi {

    @GET("verbs/{id}")
    suspend fun getVerbById(@Path("id") id: String): Response<Verb>

    @GET("nouns/{id}")
    suspend fun getNounById(@Path("id") id: String): Response<Noun>

    @GET("particles/{id}")
    suspend fun getParticleById(@Path("id") id: String): Response<Particle>

    @GET("words")
    suspend fun getWords(
        @Query("query") query: String? = null,
        @QueryMap filters: Map<String, String> = emptyMap()
    ): Response<List<WordSummary>>
}
