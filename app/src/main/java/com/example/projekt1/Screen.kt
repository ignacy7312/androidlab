package com.example.projekt1

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object SecondScreen : Screen("second_screen")
    object ThirdScreen : Screen("third_screen")


    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }


}