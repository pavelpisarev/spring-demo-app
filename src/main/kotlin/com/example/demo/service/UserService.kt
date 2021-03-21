package com.example.demo.service

import com.example.demo.model.dto.UserDto
import com.example.demo.model.entity.UserEntity

interface UserService {
    fun registerUser(userDto: UserDto): UserEntity
    fun getUserById(id: Long): UserEntity
    fun getAllUsers(): List<UserEntity>
    fun updateUser(id: Long, userDto: UserDto): UserEntity
    fun deleteUser(id: Long)
}