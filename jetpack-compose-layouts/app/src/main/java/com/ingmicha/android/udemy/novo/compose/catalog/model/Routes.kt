package com.ingmicha.android.udemy.novo.compose.catalog.model

sealed class Routes(val route: String) {
    object ScreenOne : Routes("screenOne")
    object ScreenTwo : Routes("screenTwo")
    object ScreenThree : Routes("screenThree")
    object ScreenFour : Routes("screenFour/{age}") {
        fun createRoute(age: Int) = "screenFour/$age"
    }

    object ScreenFive : Routes("screenFour?name={name}") {
        fun createRoute(name: String) = "screenFour?name=$name"
    }
}
