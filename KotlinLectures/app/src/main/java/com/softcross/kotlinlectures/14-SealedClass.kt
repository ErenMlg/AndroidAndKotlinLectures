package com.softcross.kotlinlectures

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
- Sealed classes used for the specify situation types. Sample of usage;
In android, they used for handle response, error state, success state, loading state, etc...

- In sealed class every state can storage own data this is difference from enums
 */
sealed class Response<T> {
    data class Success<T>(val data: T) : Response<T>()
    data object Loading : Response<Nothing>()

    sealed class Error : Response<Nothing>() {
        data object NetworkError : Error()
        data object WritingError : Error()
    }
}

data class ResultDto(val data: String)

fun main() = runBlocking {
    println("Error will not be thrown")

    delay(2000)

    makeNetworkResponse().collect {
        println(it)
    }

    delay(2000)

    println()
    println("Error will be thrown")

    delay(2000)
    makeNetworkResponse(true).collect {
        println(it)
    }
}

suspend fun makeNetworkResponse(isError: Boolean = false) = flow {
    emit(Response.Loading)
    delay(2000)
    try {
        if (isError) {
            throw NetworkException("Something went wrong")
        } else {
            emit(Response.Success(ResultDto("hello")))
        }
    } catch (e: Exception) {
        when (e) {
            is NetworkException -> {
                emit(Response.Error.NetworkError)
            }

            is WritingException -> {
                emit(Response.Error.WritingError)
            }
        }
    }
}

class NetworkException(override val message: String) : Exception(message)
class WritingException(override val message: String) : Exception(message)