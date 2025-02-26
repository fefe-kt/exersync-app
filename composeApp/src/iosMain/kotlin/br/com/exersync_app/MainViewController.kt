package br.com.exersync_app

import androidx.compose.ui.window.ComposeUIViewController
import br.com.exersync_app.authentication.presentation.login.LoginScreenRoot


fun MainViewController() = ComposeUIViewController { LoginScreenRoot() }