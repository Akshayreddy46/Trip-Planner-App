package com.tripplanner.routing

sealed class Screen(val route: String) {

    object SplashScreen: Screen("splash_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object MainScreen: Screen("main_screen")
    object SearchList: Screen("search_list")
    object Detail: Screen("detail_screen")
    object ProfileScreen: Screen("profile_screen")
    object ContactUsScreen: Screen("contact_us_screen")
    object BookScreen: Screen("book_screen")


}