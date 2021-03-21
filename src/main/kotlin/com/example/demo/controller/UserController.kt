package com.example.demo.controller

import com.example.demo.api.BaseResponse
import com.example.demo.model.dto.UserDto
import com.example.demo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getAllUsers(): ResponseEntity<BaseResponse> {
        return BaseResponse.ok(userService.getAllUsers())
    }

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<BaseResponse> {
        log.debug("attempt to register user: {}", userDto)
        val response = userService.registerUser(userDto)
        log.debug("registered user: {}", response)
        return BaseResponse.ok(response)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable(name = "id") id: Long): ResponseEntity<BaseResponse> {
        return BaseResponse.ok(userService.getUserById(id))
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable(name = "id") id: Long, @RequestBody userDto: UserDto): ResponseEntity<BaseResponse> {
        log.debug("attempt to update user with id $id: {}", userDto)
        val response = userService.updateUser(id, userDto)
        log.debug("updated user: {}", response)
        return BaseResponse.ok(response)

    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable(name = "id") id: Long): ResponseEntity<BaseResponse> {
        log.debug("attempt to delete user with id: {}", id)
        userService.deleteUser(id)
        log.debug("user deleted")
        return BaseResponse.ok("user deleted")

    }
}