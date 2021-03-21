package com.example.demo.service.impl

import com.example.demo.model.dto.UserDto
import com.example.demo.model.entity.UserEntity
import com.example.demo.model.mapper.UserMapper
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val passwordEncoder: PasswordEncoder
) : UserService {
    override fun registerUser(userDto: UserDto): UserEntity {
        userDto.password = passwordEncoder.encode(userDto.password)
        return userRepository.save(userMapper.dtoToEntity(userDto))
    }

    override fun getUserById(id: Long): UserEntity {
        return userRepository.findByIdOrNull(id) ?: throw EntityNotFoundException("user not found")
    }

    override fun getAllUsers(): List<UserEntity> {
        return userRepository.findAll()
    }

    override fun updateUser(id: Long, userDto: UserDto): UserEntity {
        val entity = userRepository.findByIdOrNull(id) ?: throw EntityNotFoundException("user not found")
        val requestEntity = userMapper.dtoToEntity(userDto)
        entity.email = requestEntity.email
        entity.username = requestEntity.username
        entity.password = passwordEncoder.encode(requestEntity.password)
        userRepository.save(entity)
        return entity
    }

    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}