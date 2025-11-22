package com.example.clothingapp_frontend.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.clothingapp_frontend.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {
        // Onboarding Screen
        composable(route = "onboarding") {
            OnBordingScreen(
                onContinue = { /* Handle continue if needed */ },
                onGetStartedClicked = {
                    navController.navigate("login")
                }
            )
        }

        // Login Screen
        composable(route = "login") {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var isPasswordVisible by remember { mutableStateOf(false) }

            LoginScreen(
                uiState = LoginUiState(
                    email = email,
                    password = password,
                    isPasswordVisible = isPasswordVisible
                ),
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                onTogglePasswordVisibility = { isPasswordVisible = !isPasswordVisible },
                onLogin = {
                    navController.navigate("home") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                },
                onJoin = {
                    navController.navigate("signup")
                },
                onForgotPassword = {
                    // You can add forgot password screen later
                }
            )
        }

        // Sign Up Screen
        composable(route = "signup") {
            var fullName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var isPasswordVisible by remember { mutableStateOf(false) }

            SignUpScreen(
                uiState = SignUpUiState(
                    fullName = fullName,
                    email = email,
                    password = password,
                    isPasswordVisible = isPasswordVisible
                ),
                onFullNameChange = { fullName = it },
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                onTogglePasswordVisibility = { isPasswordVisible = !isPasswordVisible },
                onCreateAccount = {
                    navController.navigate("home") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                },
                onLogin = {
                    navController.navigate("login")
                },
                onTermsClick = { /* Handle terms */ },
                onPrivacyClick = { /* Handle privacy */ },
                onCookieClick = { /* Handle cookie */ }
            )
        }

        // Home Screen
        composable(route = "home") {
            DiscoverScreenWithState(
                onSneakerClick = { product ->
                    navController.navigate("detail/${product.id}")
                },
                onCartClick = {
                    navController.navigate("cart")
                }
            )
        }

        // Detail Screen
        composable(route = "detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: "1"

            SneakerDetailScreen(
                onSneakerClick = { /* Handle sneaker click if needed */ },
                onBack = { navController.popBackStack() },
                onNotifications = { /* Handle notifications */ },
                onAddToCart = { quantity ->
                    navController.navigate("cart")
                }
            )
        }

        // Cart Screen
        composable(route = "cart") {
            CartScreen(
                onBack = { navController.popBackStack() },
                onCheckout = {
                    navController.navigate("checkout")
                },
                onNotification = { /* Handle notifications */ }
            )
        }

        // Checkout Screen
        composable(route = "checkout") {
            CheckoutScreen(
                onBack = { navController.popBackStack() },
                onPlaceOrder = {
                    navController.navigate("order_accepted")
                },
                onNotification = { /* Handle notifications */ }
            )
        }

        // Order Accepted Screen
        composable(route = "order_accepted") {
            OrderAcceptedScreen(
                onBackToHome = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onTrackOrder = {
                    // You can add order tracking screen later
                }
            )
        }
    }
}