package com.example.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.cleanarchitecture.presentation.viewmodel.MainViewModel
import com.example.cleanarchitecture.presentation.ui.HomeScreen
import com.example.cleanarchitecture.presentation.ui.ListingScreen
import com.example.cleanarchitecture.presentation.ui.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()
            val navController = rememberNavController()

            NavHost(navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(viewModel) { navController.navigate("home") }
                }
                composable("home") {
                    HomeScreen {
                        navController.navigate("listing")
                    }
                }
                composable("listing") {
                    ListingScreen(viewModel)
                }
            }
        }
    }
}