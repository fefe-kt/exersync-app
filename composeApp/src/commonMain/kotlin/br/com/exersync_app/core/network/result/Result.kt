package br.com.exersync_app.core.network.result

import br.com.exersync_app.core.network.error.ResultError

sealed interface Result<out D, out E : ResultError> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Failure<out E : ResultError>(val error: E) : Result<Nothing, E>
}

inline fun <T, E : ResultError, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Failure -> Result.Failure(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T, E : ResultError> Result<T, E>.asEmptyDataResult(): Result<Unit, E> {
    return map { }
}

inline fun <T, E : ResultError> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Failure -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : ResultError> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Failure -> {
            action(error)
            this
        }

        is Result.Success -> this
    }
}