package br.com.exersync_app.app

import kotlinx.serialization.Serializable

interface Routes {

    @Serializable
    data object Login : Routes

    @Serializable
    data object SignUp : Routes

    @Serializable
    data object OAuth : Routes

    @Serializable
    data object ForgotPassword : Routes
}