package ru.kheynov.kabanchik

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.yandex.authsdk.YandexAuthLoginOptions
import com.yandex.authsdk.YandexAuthOptions
import com.yandex.authsdk.YandexAuthResult
import com.yandex.authsdk.YandexAuthSdk

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val sdk = YandexAuthSdk.create(YandexAuthOptions(applicationContext))
            val authActivityResultLauncher =
                rememberLauncherForActivityResult(sdk.contract) { yandexAuthResult ->
                    when (yandexAuthResult) {
                        YandexAuthResult.Cancelled ->
                            Toast.makeText(
                                applicationContext,
                                "Auth cancelled",
                                Toast.LENGTH_SHORT
                            ).show()

                        is YandexAuthResult.Failure -> Toast.makeText(
                            context,
                            "Auth failed ${yandexAuthResult.exception.message}",
                            Toast.LENGTH_SHORT
                        ).show()

                        is YandexAuthResult.Success -> Log.i(
                            TAG,
                            "Auth successful: ${yandexAuthResult.token}"
                        )
                    }
                }
            AuthScreen(onAction = {
                when (it) {
                    AuthScreenActions.LoginClicked -> authActivityResultLauncher.launch(
                        YandexAuthLoginOptions()
                    )
                }
            })
        }
    }

    @Composable
    private fun registerAuthActivityForResult(
        sdk: YandexAuthSdk,
        onResult: (YandexAuthResult) -> Unit
    ): ActivityResultLauncher<YandexAuthLoginOptions> =
        rememberLauncherForActivityResult(sdk.contract) { result -> onResult(result) }
}


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}