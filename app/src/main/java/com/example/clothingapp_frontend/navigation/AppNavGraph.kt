package com.example.clothingapp_frontend.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clothingapp_frontend.screens.*

object Routes {
    const val OnBoarding = "onboarding"
    const val Login = "login"
    const val SignUp = "signup"
    const val Discover = "discover"
    const val SneakerDetail = "sneaker_detail"
    const val Cart = "cart"
    const val Checkout = "checkout"
    const val OrderAccepted = "order_accepted"
}

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.OnBoarding,
        modifier = modifier
    ) {
        composable(Routes.OnBoarding) {
            OnBordingScreen(
                onContinue = { navController.navigate(Routes.Login) }
            )
        }

        composable(Routes.Login) {
            LoginScreenWithState(
                onLoginSuccess = { navController.navigate(Routes.Discover) },
                onSignUpClick = { navController.navigate(Routes.SignUp) }
            )
        }

        composable(Routes.SignUp) {
            SignUpScreenWithState(
                onSignUpSuccess = { navController.navigate(Routes.Discover) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.Discover) {
            DiscoverScreenWithState(
                onSneakerClick = { navController.navigate(Routes.SneakerDetail) },
                onCartClick = { navController.navigate(Routes.Cart) }
            )
        }

        composable(Routes.SneakerDetail) {
            SneakerDetailScreen(
                onAddToCart = { navController.navigate(Routes.Cart) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.Cart) {
            CartScreen(
                onBack = { navController.popBackStack() },
                onCheckout = { navController.navigate(Routes.Checkout) }
            )
        }

        composable(Routes.Checkout) {
            CheckoutScreen(
                onBack = { navController.popBackStack() },
                onPlaceOrder = { navController.navigate(Routes.OrderAccepted) }
            )
        }

        composable(Routes.OrderAccepted) {
            OrderAcceptedScreen(
                onTrackOrder = { /* Handle track order */ },
                onBackToHome = {
                    // Clear backstack and go to Discover/Home
                    navController.navigate(Routes.Discover) {
                        popUpTo(Routes.Discover) { inclusive = true }
                    }
                }
            )
        }
    }
}
