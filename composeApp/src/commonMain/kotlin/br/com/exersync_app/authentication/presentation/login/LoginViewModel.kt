package br.com.exersync_app.authentication.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnSocialLoginButtonClicked -> {}
            LoginAction.OnForgotPasswordButtonClicked -> TODO()
            LoginAction.OnSignupButtonClicked -> TODO()
            is LoginAction.OnSubmitButtonClicked -> {
            }

            is LoginAction.OnEmailTextChanged -> {
                _state.update {
                    it.copy(emailText = action.emailText)
                }
            }

            is LoginAction.OnPasswordTextChanged -> {
                _state.update {
                    it.copy(passwordText = action.passwordText)
                }
            }

            LoginAction.OnPasswordVisibilityChanged -> {
                _state.update {
                    it.copy(isPasswordVisible = !it.isPasswordVisible)
                }
            }
        }
    }
}