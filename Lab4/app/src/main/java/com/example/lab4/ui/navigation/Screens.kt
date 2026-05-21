package com.example.lab4.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens{

    @Serializable
    object Home: Screens()

    @Serializable
    object TaskScreen: Screens()

}