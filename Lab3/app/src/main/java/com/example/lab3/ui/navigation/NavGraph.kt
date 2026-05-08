package com.example.lab3.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab3.ui.screens.HomeScreen
import com.example.lab3.ui.screens.Screen1
import com.example.lab3.ui.screens.SensorScreen1

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Screens.Home> {
                HomeScreen(
                    onNavigateToList = { navController.navigate(Screens.ListScreen) },
                    onNavigateToSensor = { navController.navigate(Screens.SensorScreen1) }
                )
            }
            composable<Screens.ListScreen> {
                Screen1()
            }
            composable<Screens.SensorScreen1> {
                SensorScreen1()
            }
        }
    }
}

