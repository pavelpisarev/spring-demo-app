package com.example.demo.controller

import com.example.demo.api.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.persistence.EntityNotFoundException

@RestControllerAdvice
class ExceptionController {
    @ExceptionHandler(value = [RuntimeException::class])
    fun runtimeExceptionHandler(runtimeException: RuntimeException): ResponseEntity<BaseResponse> {
        return BaseResponse.nok(runtimeException.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun entityNotFoundException(entityNotFoundException: EntityNotFoundException): ResponseEntity<BaseResponse> {
        return BaseResponse.nok(entityNotFoundException.message, HttpStatus.NOT_FOUND)
    }
}