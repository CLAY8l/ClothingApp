package com.example.clothingapp_frontend.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object Detail : Screen("detail")
    object Cart : Screen("cart")
    object Checkout : Screen("checkout")
    object OrderAccepted : Screen("order_accepted")
}