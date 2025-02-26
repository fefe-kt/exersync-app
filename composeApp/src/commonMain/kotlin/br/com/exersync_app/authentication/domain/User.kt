package br.com.exersync_app.authentication.domain

data class User(
    val id: String,
    val name: String,
    val userName: String,
    val profilePictureUrl: String?,
)
