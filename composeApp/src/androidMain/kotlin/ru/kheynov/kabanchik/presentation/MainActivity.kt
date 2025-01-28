package ru.kheynov.kabanchik.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.kheynov.kabanchik.App
import ru.kheynov.kabanchik.presentation.screen.AuthScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthScreen({ })
        }
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}