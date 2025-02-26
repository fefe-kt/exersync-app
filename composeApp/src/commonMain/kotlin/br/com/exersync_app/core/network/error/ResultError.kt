package br.com.exersync_app.core.network.error

sealed interface ResultError {
    enum class ServerError : ResultError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        SERIALIZATION,
        UNKNOWN
    }

    enum class ClientError : ResultError {
        NOT_ENOUGH_SPACE,
        UNKNOWN
    }
}