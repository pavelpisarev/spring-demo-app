package com.example.demo

import com.example.demo.model.mapper.UserMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
@MockBean(UserMapper::class)
class DemoApplicationTests {

    @Test
    fun contextLoads() {
    }

}