package ru.kheynov.kabanchik.presentation.components.auth

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.yandex.authsdk.YandexAuthLoginOptions
import com.yandex.authsdk.YandexAuthOptions
import com.yandex.authsdk.YandexAuthResult
import com.yandex.authsdk.YandexAuthSdk
import ru.kheynov.kabanchik.auth.OAuthResult
import ru.kheynov.kabanchik.auth.OAuthToken
import ru.kheynov.kabanchik.utils.logger.KLogger

private const val TAG = "YandexAuthScreen"

@Composable
actual fun YandexAuthScreen(
    onResult: (OAuthResult) -> Unit,
) {
    val context = LocalContext.current
    val sdk = YandexAuthSdk.create(YandexAuthOptions(context))
    val authActivityResultLauncher =
        rememberLauncherForActivityResult(sdk.contract) { yandexAuthResult ->
            when (yandexAuthResult) {
                YandexAuthResult.Cancelled -> {
                    KLogger.i(TAG, "Auth cancelled")
                    onResult(OAuthResult.Cancelled)
                }

                is YandexAuthResult.Failure -> {
                    KLogger.e(TAG, "Auth failed", throwable = yandexAuthResult.exception)
                    onResult(
                        OAuthResult.Failure(
                            reason = yandexAuthResult.exception.message,
                            yandexAuthResult.exception
                        )
                    )
                }

                is YandexAuthResult.Success -> {
                    KLogger.i(
                        TAG,
                        "Auth successful: ${yandexAuthResult.token}"
                    )
                    onResult(
                        OAuthResult.Success(
                            OAuthToken(
                                yandexAuthResult.token.value,
                                yandexAuthResult.token.expiresIn
                            )
                        )
                    )
                }
            }
        }

    LaunchedEffect(1) {
        authActivityResultLauncher.launch(YandexAuthLoginOptions())
    }
}