package dev.arabicdictionary.pro.features.auth

import dev.arabicdictionary.pro.core.utils.validateEmail

/**
 * Classifies user auth text
 */
internal class ValidateUserAuthTextUseCase {
    private val frameTokenRegex = Regex("[-\\w]+")

    operator fun invoke(authText: String): Result =
        when {
            authText.isBlank() -> Result.EMPTY
            validateEmail(authText) -> Result.EMAIL
            frameTokenRegex.matches(authText) -> Result.MAYBE_TOKEN
            else -> Result.UNKNOWN
        }

    enum class Result {
        /**
         * Auth text is blank
         */
        EMPTY,

        /**
         * Auth text is email
         */
        EMAIL,

        /**
         * Auth text looks like token, but need verification from the server
         */
        MAYBE_TOKEN,

        /**
         * Everything else that can't be classified
         */
        UNKNOWN,
    }
}
