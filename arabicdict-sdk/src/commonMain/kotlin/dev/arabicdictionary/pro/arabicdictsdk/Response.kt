package dev.arabicdictionary.pro.arabicdictsdk

import dev.arabicdictionary.pro.arabicdictsdk.data.ArabicApiError

/**
 * Represents the result of an API operation.
 */
sealed class Response<out T> {
    /**
     * Represents a successful API operation with data.
     *
     * @param data The data returned from the API.
     */
    data class Success<T>(
        val httpCode: Int,
        val data: T,
    ) : Response<T>()

    /**
     * Represents a failed API operation.
     *
     * @param code The error code.
     * @param message The error message.
     */
    data class NetworkError(
        val httpCode: Int,
        val error: ArabicApiError? = null,
    ) : Response<Nothing>()

    /**
     * Represents a failed API operation.
     *
     * @param code The error code.
     * @param message The error message.
     */
    data class Error(
        val throwable: Throwable,
    ) : Response<Nothing>()
}
