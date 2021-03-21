package com.example.demo.controller

import com.example.demo.api.BaseResponse
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@RestController
class CustomErrorController : ErrorController {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun getErrorPath(): String? {
        return "/error"
    }

    @RequestMapping("/error")
    fun error(request: HttpServletRequest): ResponseEntity<BaseResponse> {
        val errorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString().toInt()
        val errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE)
        log.info("/error - $errorMessage")
        return BaseResponse.nok(errorMessage, errorCode)
    }
}