package com.example.ecotracks.ui

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object LearnScreen: Screen("learn_screen")
}