package br.com.exersync_app.authentication.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.exersync_app.core.presentation.DefaultSecureTextField
import br.com.exersync_app.core.presentation.DefaultTextField
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LoginScreenRoot(
    viewModel: LoginViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    LoginScreen(state.value, viewModel::onAction)
}

@Preview
@Composable
private fun LoginScreen(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextField(
            textValue = state.emailText.orEmpty(),
            onValueChange = { emailText ->
                onAction(LoginAction.OnEmailTextChanged(emailText))
            },
            modifier = Modifier.widthIn(max = 400.dp).fillMaxWidth()
                .padding(24.dp),
            placeholder = "Digite seu email"
        )
        DefaultSecureTextField(
            textValue = state.passwordText.orEmpty(),
            onValueChange = { passwordText ->
                onAction(LoginAction.OnPasswordTextChanged(passwordText))
            },
            modifier = Modifier.widthIn(max = 400.dp).fillMaxWidth()
                .padding(24.dp),
            placeholder = "Digite sua senha",
            isPasswordVisible = state.isPasswordVisible,
            onChangeVisibility = { onAction(LoginAction.OnPasswordVisibilityChanged) }
        )
        Button(
            onClick = { onAction(LoginAction.OnSubmitButtonClicked) },
            content = { Text("Efetuar login") }
        )
    }
}


