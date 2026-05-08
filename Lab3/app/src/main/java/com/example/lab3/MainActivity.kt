package com.example.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab3.ui.navigation.AppNavigation
import com.example.lab3.ui.navigation.Screens
import com.example.lab3.ui.screens.HomeScreen
import com.example.lab3.ui.screens.Screen1
import com.example.lab3.ui.screens.SensorScreen1
import com.example.lab3.ui.theme.Lab3Theme

class  MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3Theme {
                AppNavigation()
            }
        }
    }
}



