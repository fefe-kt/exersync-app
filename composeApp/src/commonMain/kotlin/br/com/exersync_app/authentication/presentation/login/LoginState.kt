package br.com.exersync_app.authentication.presentation.login

data class LoginState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val emailText: String? = null,
    val passwordText: String? = null,
    val isPasswordVisible: Boolean = false
)