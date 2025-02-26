package br.com.exersync_app.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.com.exersync_app.authentication.presentation.login.LoginScreenRoot
import br.com.exersync_app.authentication.presentation.login.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    LoginScreenRoot(viewModel = remember { LoginViewModel() }, Modifier.fillMaxSize())
}