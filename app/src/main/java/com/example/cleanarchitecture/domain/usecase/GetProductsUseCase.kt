package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetProductsUseCase(private val repository: UserRepository) {
    suspend fun execute(): List<Product> {
        return repository.getProducts()
    }
}