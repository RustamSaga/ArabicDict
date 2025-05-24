package dev.arabicdictionary.pro.features.auth

import dev.arabicdictionary.pro.navstate.Navigator
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal fun authFeatureKoinModule(): Module {
    return module {
        viewModel {
            AuthViewModel(
                navigator = get<Navigator>(),
                validateUserAuthTextUseCaseProvider = ::get,
                checkUserFrameTokenUseCaseProvider = ::get,
            )
        }

        factoryOf(::ValidateUserAuthTextUseCase)

        factoryOf(::CheckUserFrameTokenUseCase)

        scope(authKoinScopeQualifier) {
            // Add scoped dependencies
        }
    }
}

internal const val AUTH_SCOPE_ID = "dev.arabicdictionary.pro.features.auth"

internal val authKoinScopeQualifier
    get() = named(AUTH_SCOPE_ID)