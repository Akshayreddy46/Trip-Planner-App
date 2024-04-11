package com.tripplanner.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tripplanner.ui.bookScreen.BookScreen
import com.tripplanner.ui.contact_us.ContactUsScreen
import com.tripplanner.ui.detail.DetailScreen
import com.tripplanner.ui.login.LoginScreen
import com.tripplanner.ui.main.MainScreen
import com.tripplanner.ui.profileScreen.ProfileScreen
import com.tripplanner.ui.register.RegisterScreen
import com.tripplanner.ui.searchListing.SearchScreen
import com.tripplanner.ui.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Detail.route) {
            DetailScreen(navController = navController)
        }
        composable(route = Screen.SearchList.route) {
            SearchScreen(navController = navController)
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.ContactUsScreen.route) {
            ContactUsScreen(navController = navController)
        }
        composable(route = Screen.BookScreen.route) {
            BookScreen(navController = navController)
        }
    }

}