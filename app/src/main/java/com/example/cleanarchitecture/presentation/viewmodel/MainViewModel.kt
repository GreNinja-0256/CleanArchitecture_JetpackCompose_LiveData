package com.example.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.*
import com.example.cleanarchitecture.data.network.NetworkModule
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.domain.model.User
import com.example.cleanarchitecture.domain.usecase.GetProductsUseCase
import com.example.cleanarchitecture.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

open class MainViewModel : ViewModel() {
    private val repository = UserRepositoryImpl(NetworkModule.apiService)
    private val loginUseCase = LoginUseCase(repository)
    private val getProductsUseCase = GetProductsUseCase(repository)

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    open fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = loginUseCase.execute(username, password)
            _user.postValue(result)
        }
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _products.postValue(getProductsUseCase.execute())
        }
    }
}