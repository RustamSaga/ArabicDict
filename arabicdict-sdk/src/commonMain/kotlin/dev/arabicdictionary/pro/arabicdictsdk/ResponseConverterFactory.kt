package dev.arabicdictionary.pro.arabicdictsdk

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import dev.arabicdictionary.pro.arabicdictsdk.Response
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import dev.arabicdictionary.pro.arabicdictsdk.Response as ArabicResponse

internal class ResponseConverterFactory : Converter.Factory {
    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit,
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        if (typeData.typeInfo.type == ArabicResponse::class) {
            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(result: KtorfitResult): Any =
                    when (result) {
                        is KtorfitResult.Failure -> ArabicResponse.Error(result.throwable)
                        is KtorfitResult.Success -> result.toFrameResponse(typeData)
                    }
            }
        }
        return null
    }

    @Suppress("MagicNumber")
    private suspend fun KtorfitResult.Success.toFrameResponse(typeData: TypeData): ArabicResponse<*> =
        when {
            response.status.value in 200..299 && typeData.typeArgs[0].typeInfo.type == Unit::class ->
                ArabicResponse.Success<Unit>(
                    httpCode = response.status.value,
                    data = Unit,
                )

            response.status.value in 200..299 ->
                ArabicResponse.Success<Any>(
                    httpCode = response.status.value,
                    data = response.body(typeData.typeArgs.first().typeInfo),
                )

            else ->
                Response.NetworkError(
                    httpCode = response.status.value,
                    error = response.body(typeData.typeArgs.first().typeInfo),
                )
        }
}
