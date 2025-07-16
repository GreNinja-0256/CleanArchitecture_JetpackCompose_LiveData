package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.repository.UserRepository

class LoginUseCase(private val repository: UserRepository) {
    suspend fun execute(username: String, password: String): User {
        return repository.login(username, password)
    }
}