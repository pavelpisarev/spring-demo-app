package com.example.demo.model.mapper

import com.example.demo.model.dto.UserDto
import com.example.demo.model.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {
    @Mapping(target = "id", ignore = true)
    fun entityToDto(userEntity: UserEntity): UserDto

    @Mapping(target = "id", ignore = true)
    fun dtoToEntity(userDto: UserDto): UserEntity
}