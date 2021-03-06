package com.example.demo.model.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "username")
    var username: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "password")
    var password: String? = null,
)