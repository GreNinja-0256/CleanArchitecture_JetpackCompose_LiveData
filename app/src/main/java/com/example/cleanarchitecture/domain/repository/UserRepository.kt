package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.model.Product

interface UserRepository {
    suspend fun login(username: String, password: String): User
    suspend fun getProducts(): List<Product>
}