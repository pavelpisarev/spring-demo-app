package com.example.demo.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BaseResponse {
    var message: Any? = null
    var error: Any? = null

    companion object {
        fun ok(message: Any?): ResponseEntity<BaseResponse> {
            val response = BaseResponse()
            response.message = message
            return ResponseEntity.ok().body(response)
        }

        fun nok(error: Any?, status: HttpStatus): ResponseEntity<BaseResponse> {
            val response = BaseResponse()
            response.error = error
            return ResponseEntity.status(status).body(response)
        }

        fun nok(error: Any?, status: Int): ResponseEntity<BaseResponse> {
            val response = BaseResponse()
            response.error = error
            return ResponseEntity.status(status).body(response)
        }
    }
}