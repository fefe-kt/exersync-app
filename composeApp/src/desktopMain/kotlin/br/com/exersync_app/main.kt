package br.com.exersync_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.exersync_app.authentication.presentation.login.LoginScreenRoot

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "exersync-app",
    ) {
        LoginScreenRoot()
    }
}