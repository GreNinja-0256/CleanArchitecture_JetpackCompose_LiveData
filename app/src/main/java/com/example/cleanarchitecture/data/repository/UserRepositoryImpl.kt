package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.api.ApiService
import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {
    override suspend fun login(username: String, password: String): User {
        return User(username = username, token = "fake_token_123")
    }

    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts().map {
            Product(id = it.id, title = it.title)
        }
    }
}