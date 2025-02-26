package br.com.exersync_app.authentication.presentation.login

sealed interface LoginAction {
    data class OnEmailTextChanged(val emailText: String) : LoginAction
    data class OnPasswordTextChanged(val passwordText: String) : LoginAction
    data object OnPasswordVisibilityChanged : LoginAction
    data object OnSignupButtonClicked : LoginAction
    data object OnForgotPasswordButtonClicked : LoginAction
    data object OnSocialLoginButtonClicked : LoginAction
    data object OnSubmitButtonClicked : LoginAction
}