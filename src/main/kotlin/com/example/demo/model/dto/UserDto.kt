package com.example.demo.model.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

class UserDto {
    @field:Null
    var id: Long? = null

    @field:NotBlank
    var username: String? = null

    @field:NotBlank
    var email: String? = null

    @field:NotBlank
    var password: String? = null
}