package dev.arabicdictionary.pro.features.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import arabicdictionarypro.features.auth.ui.generated.resources.Res
import arabicdictionarypro.features.auth.ui.generated.resources.auth_in_progress
import arabicdictionarypro.features.auth.ui.generated.resources.auth_user_data_hint
import arabicdictionarypro.features.auth.ui.generated.resources.choosing_language
import arabicdictionarypro.features.auth.ui.generated.resources.dont_have_account
import arabicdictionarypro.features.auth.ui.generated.resources.error_arabicdict_dev_token
import arabicdictionarypro.features.auth.ui.generated.resources.error_email_auth_not_supported
import arabicdictionarypro.features.auth.ui.generated.resources.error_invalid_auth_text
import arabicdictionarypro.features.auth.ui.generated.resources.error_server_error
import arabicdictionarypro.features.auth.ui.generated.resources.error_unknown
import arabicdictionarypro.features.auth.ui.generated.resources.localization
import arabicdictionarypro.features.auth.ui.generated.resources.next
import arabicdictionarypro.features.auth.ui.generated.resources.request_token
import arabicdictionarypro.features.auth.ui.generated.resources.signup
import arabicdictionarypro.features.auth.ui.generated.resources.waiting_message
import arabicdictionarypro.features.auth.ui.generated.resources.welcome
import arabicdictionarypro.features.auth.ui.generated.resources.welcome_message
import arabicdictionarypro.features.auth.ui.generated.resources.lang
import dev.arabicdictionary.pro.core.uikit.ArabicDictTheme
import dev.arabicdictionary.pro.core.uikit.localization.ArabicDictLanguage
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.module.rememberKoinModules
import org.koin.compose.scope.KoinScope
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
public fun AuthPane(
    onChangeLanguage: (ArabicDictLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    KoinScope(AUTH_SCOPE_ID, authKoinScopeQualifier) {
        rememberKoinModules {
            listOf(authFeatureKoinModule())
        }
        AuthPane(
            onChangeLanguage = onChangeLanguage,
            viewModel = koinViewModel(),
            modifier = modifier,
        )
    }
}

@Composable
private fun AuthPane(
    onChangeLanguage: (ArabicDictLanguage) -> Unit,
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState().value
    val localization = viewModel.localizationState.collectAsState().value

    when (state) {
        is AuthState.Default ->
            AuthPane(
                onChangeLanguage = onChangeLanguage,
                state = state,
                localization = localization,
                onNextClick = { viewModel.onEvent(AuthEvent.OnNextClicked()) },
                onRequestTokenClick = { viewModel.onEvent(AuthEvent.OnRequestTokenClick()) },
                onSignUpClick = { viewModel.onEvent(AuthEvent.OnSignUpClick()) },
                onUserAuthTextChange = { text -> viewModel.onEvent(AuthEvent.OnUserAuthTextChanged(text)) },
                modifier = modifier,
            )

        is AuthState.Loading -> Authorizing(modifier)
    }
}

@Composable
private fun Authorizing(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = stringResource(Res.string.auth_in_progress),
            color = ArabicDictTheme.colors.onSurface,
            style = ArabicDictTheme.typography.titleLarge,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.waiting_message),
            color = ArabicDictTheme.colors.onSurfaceVariant,
            style = ArabicDictTheme.typography.labelLarge,
        )
        Spacer(Modifier.height(48.dp))
        CircularProgressIndicator(Modifier.size(48.dp))
    }
}

@Composable
@Suppress("LongParameterList")
private fun AuthPane(
    onChangeLanguage: (ArabicDictLanguage) -> Unit,
    state: AuthState.Default,
    localization: StringProvider,
    onNextClick: () -> Unit,
    onUserAuthTextChange: (String) -> Unit,
    onRequestTokenClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AuthPane(
        localization = localization,
        onChangeLanguage = onChangeLanguage,
        userAuthText = state.userAuthText,
        errorString = readableMessageForError(state.error),
        onNextClick = onNextClick,
        onUserAuthTextChange = onUserAuthTextChange,
        onRequestTokenClick = onRequestTokenClick,
        onSignUpClick = onSignUpClick,
        modifier,
    )
}

@Composable
private fun readableMessageForError(error: AuthError?) =
    when (error) {
        AuthError.INVALID_AUTH_TEXT -> stringResource(Res.string.error_invalid_auth_text)
        AuthError.INVALID_ARABICDICT_DEV_TOKEN -> stringResource(Res.string.error_arabicdict_dev_token)
        AuthError.EMAIL_AUTH_NOT_SUPPORTED -> stringResource(Res.string.error_email_auth_not_supported)
        AuthError.SERVER_ERROR -> stringResource(Res.string.error_server_error)
        AuthError.UNKNOWN -> stringResource(Res.string.error_unknown)
        null -> null
    }

@Composable
@Suppress("LongParameterList")
internal fun AuthPane(
    localization: StringProvider,
    onChangeLanguage: (ArabicDictLanguage) -> Unit,
    userAuthText: String,
    errorString: String?,
    onNextClick: () -> Unit,
    onUserAuthTextChange: (String) -> Unit,
    onRequestTokenClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.widthIn(max = 400.dp),
    ) {
        Header()

        Spacer(Modifier.height(48.dp))

        UserDataTextField(
            errorString,
            userAuthText,
            onUserAuthTextChange,
            onNextClick,
        )

        Spacer(Modifier.height(48.dp))

        Actions(onNextClick, onRequestTokenClick)

        Spacer(Modifier.height(24.dp))

        SignUp(onSignUpClick)

        Spacer(Modifier.height(24.dp))

        Localization(
            selected = localization,
            onChange = onChangeLanguage
        )
    }
}

@Composable
private fun ColumnScope.SignUp(onSignUpClick: () -> Unit) {
    val text =
        buildAnnotatedString {
            append(stringResource(Res.string.dont_have_account))
            withLink(
                LinkAnnotation.Clickable(
                    tag = "frame_signup",
                    styles =
                        TextLinkStyles(
                            style =
                                SpanStyle(
                                    color = ArabicDictTheme.colors.primary,
                                    fontWeight = FontWeight.Bold,
                                    textDecoration = TextDecoration.Underline,
                                ),
                        ),
                    linkInteractionListener = { onSignUpClick() },
                ),
            ) {
                append(stringResource(Res.string.signup))
            }
        }

    Text(
        text,
        style = ArabicDictTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        color = ArabicDictTheme.colors.onSurfaceVariant,
    )
}

@Composable
private fun ColumnScope.UserDataTextField(
    errorString: String?,
    userAuthText: String,
    onUserAuthTextChange: (String) -> Unit,
    onNextClick: () -> Unit,
) {
    val supportingText: @Composable (() -> Unit)? = errorString?.let { { Text(text = it) } }
    OutlinedTextField(
        value = userAuthText,
        onValueChange = onUserAuthTextChange,
        isError = errorString != null,
        label = {
            Text(
                stringResource(Res.string.auth_user_data_hint),
                color = ArabicDictTheme.colors.primary,
                maxLines = 1,
                style = ArabicDictTheme.typography.bodySmall,
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        keyboardActions = KeyboardActions(onGo = { onNextClick() }),
        modifier = Modifier.fillMaxWidth(),
        supportingText = supportingText,
    )
}

@Composable
private fun ColumnScope.Actions(
    onNextClick: () -> Unit,
    onRequestTokenClick: () -> Unit,
) {
    Column(Modifier.wrapContentSize()) {
        FilledTonalButton(
            onClick = onNextClick,
            shape = ArabicDictTheme.shapes.small,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = stringResource(Res.string.next))
        }

        Spacer(Modifier.height(10.dp))

        OutlinedButton(
            onClick = onRequestTokenClick,
            shape = ArabicDictTheme.shapes.small,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = stringResource(Res.string.request_token))
        }
    }
}

@Composable
private fun ColumnScope.Header() {
    Text(
        text = stringResource(Res.string.welcome),
        maxLines = 1,
        color = ArabicDictTheme.colors.onSurface,
        style = ArabicDictTheme.typography.headlineLarge,
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = stringResource(Res.string.welcome_message),
        maxLines = 2,
        color = ArabicDictTheme.colors.onSurfaceVariant,
        style = ArabicDictTheme.typography.labelLarge,
    )
}

@Composable
private fun ColumnScope.Localization(
    selected: StringProvider,
    onChange: (ArabicDictLanguage) -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(Res.string.choosing_language)) },
            text = {
                Column {
                    LanguageOption(ArabicDictLanguage.English, selected, onChange, onDismiss = { showDialog = false })
                    LanguageOption(ArabicDictLanguage.Russian, selected, onChange, onDismiss = { showDialog = false })
                    LanguageOption(ArabicDictLanguage.Arabic,  selected, onChange, onDismiss = { showDialog = false })
                }
            },
            confirmButton = {},
        )
    }

    val text =
        buildAnnotatedString {
            withLink(
                LinkAnnotation.Clickable(
                    tag = "localization",
                    styles =
                        TextLinkStyles(
                            style =
                                SpanStyle(
                                    color = ArabicDictTheme.colors.primary,
                                    fontWeight = FontWeight.Bold,
                                    textDecoration = TextDecoration.Underline,
                                ),
                        ),
                    linkInteractionListener = { showDialog = true },
                ),
            ) {
                append(stringResource(Res.string.localization))
            }
        }

    Text(
        text,
        style = ArabicDictTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        color = ArabicDictTheme.colors.onSurfaceVariant,
    )
}

@Composable
private fun LanguageOption(
    language: ArabicDictLanguage,
    selected: StringProvider,
    onSelect: (ArabicDictLanguage) -> Unit,
    onDismiss: () -> Unit
) {
    Text(
        text = language.value,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(language)
                onDismiss()
            }
            .padding(8.dp),
        textDecoration = if (selected.get(Res.string.lang)==language.iso) TextDecoration.Underline else null
    )
}

