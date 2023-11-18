package com.example.projekt1

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object SecondScreen : Screen("second_screen")
    object ThirdScreen : Screen("third_screen")
}