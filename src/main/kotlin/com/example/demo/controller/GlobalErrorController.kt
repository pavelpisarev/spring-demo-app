package com.example.demo.controller

import com.example.demo.api.BaseResponse
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController

class GlobalErrorController : ErrorController {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun getErrorPath(): String? {
        return null
    }

    fun getStatus(request: HttpServletRequest): HttpStatus {
        val status = request.getAttribute("javax.servlet.error.status_code").toString().toInt()
        return try {
            HttpStatus.valueOf(status)
        } catch (e: Exception) {
            HttpStatus.INTERNAL_SERVER_ERROR
        }
    }

    @RequestMapping("/error")
    fun error(request: HttpServletRequest): ResponseEntity<BaseResponse> {
        val errorCode = getStatus(request)
        log.info("/error: $errorCode")
        return BaseResponse.nok("an error acquired", getStatus(request))
    }
}