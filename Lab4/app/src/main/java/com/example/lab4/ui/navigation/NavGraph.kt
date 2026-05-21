package com.example.lab4.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4.ui.screens.GeneralViewModel
import com.example.lab4.ui.screens.HomeScreen
import com.example.lab4.ui.screens.TaskScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val viewModel: GeneralViewModel = viewModel()
        NavHost(
            navController = navController,
            startDestination = Screens.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Screens.Home> {
                HomeScreen(
                    onNavigateToList = { navController.navigate(Screens.TaskScreen) },
                )
            }
            composable<Screens.TaskScreen> {
                TaskScreen(viewModel = viewModel)
            }
        }
    }
}

