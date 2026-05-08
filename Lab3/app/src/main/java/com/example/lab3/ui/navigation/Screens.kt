package com.example.lab3.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens{

    @Serializable
    object Home: Screens()

    @Serializable
    object ListScreen: Screens()

    @Serializable
    object SensorScreen1: Screens()

}