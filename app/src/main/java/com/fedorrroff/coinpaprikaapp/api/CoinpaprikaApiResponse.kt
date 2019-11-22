package com.fedorrroff.coinpaprikaapp.api

import okhttp3.Headers
import retrofit2.Response

sealed class CoinpaprikaApiResponse<T>(
    private val response: Response<T>? = null,
    val code: Int = 0,
    val message: String? = null,
    val headers: Headers? = null
) {

    fun getHeader(header: String) = headers?.get(header)

    class Success<T>(response: Response<T>) : CoinpaprikaApiResponse<T>(
        response = response,
        code = response.code(),
        message = response.message(),
        headers = response.headers()
    ) {
        val body = response.body() ?: Unit as T
    }

    class Error<T>(
        val throwable: Throwable,
        response: Response<T>? = null,
        code: Int = response?.code() ?: INTERNAL,
        message: String? = response?.message(),
        headers: Headers? = response?.headers()
    ) : CoinpaprikaApiResponse<T>(response, code, message, headers) {

        fun isInternal() = code == INTERNAL

        companion object {
            const val INTERNAL = -1000
        }
    }
}