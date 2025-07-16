package com.example.cleanarchitecture.data.api

import com.example.cleanarchitecture.data.model.ProductDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}