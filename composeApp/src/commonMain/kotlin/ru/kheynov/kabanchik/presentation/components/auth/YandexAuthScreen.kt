package ru.kheynov.kabanchik.presentation.components.auth

import androidx.compose.runtime.Composable
import ru.kheynov.kabanchik.auth.OAuthResult

@Composable
expect fun YandexAuthScreen(
    onResult: (OAuthResult) -> Unit
)