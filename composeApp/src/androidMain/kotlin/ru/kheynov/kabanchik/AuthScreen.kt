package ru.kheynov.kabanchik

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.kheynov.kabanchik.AuthScreenActions.LoginClicked

sealed interface AuthScreenActions {
    data object LoginClicked : AuthScreenActions
}

@Composable
fun AuthScreen(
    onAction: (AuthScreenActions) -> Unit
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { onAction(LoginClicked) }) {
            Text(text = "Login via Yandex")
        }
    }
}