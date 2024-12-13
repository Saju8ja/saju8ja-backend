package com.kimsisters.saju8ja.global.util

import org.springframework.http.ResponseEntity

data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val traceId: String,
    val data: T? = null,
) {
    companion object {
        fun ok(): ResponseEntity<ApiResponse<Unit>> {
            return ResponseEntity.ok(
                ApiResponse(
                    code = 200,
                    message = "SUCCESS",
                    traceId = getTraceId(),
                )
            )
        }

        fun <T> okData(data: T): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.ok(
                ApiResponse(
                    code = 200,
                    message = "SUCCESS",
                    traceId = getTraceId(),
                    data = data
                )
            )
        }

        fun error(code: Int, message: String): ApiResponse<Nothing> {
            return ApiResponse(
                code = code,
                message = message,
                traceId = getTraceId(),
                data = null
            )
        }
    }
}

fun getTraceId(): String {
    return "test"
}
