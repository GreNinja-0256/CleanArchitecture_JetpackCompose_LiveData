package com.example.cleanarchitecture.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState

import com.example.cleanarchitecture.presentation.viewmodel.MainViewModel

@Composable
fun ListingScreen(viewModel: MainViewModel) {
    val products by viewModel.products.observeAsState(emptyList()) // ← FIXED!

    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(products) { product ->
            Text("${product.id}. ${product.title}")
            Divider()
        }
    }
}