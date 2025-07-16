package com.example.cleanarchitecture.data.network

import com.example.cleanarchitecture.data.api.ApiService

object NetworkModule {
    val apiService: ApiService by lazy {
        RetrofitInstance.retrofit.create(ApiService::class.java)
    }
}