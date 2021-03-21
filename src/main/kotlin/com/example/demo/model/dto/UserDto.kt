package com.example.demo.model.dto

data class UserDto(
    var id: Long? = null,
    var username: String? = null,
    var email: String? = null,
    var password: String? = null,
)