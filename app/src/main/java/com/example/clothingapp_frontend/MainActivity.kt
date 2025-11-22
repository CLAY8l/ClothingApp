package com.example.clothingapp_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.clothingapp_frontend.screens.CartScreen
import com.example.clothingapp_frontend.screens.CheckoutScreen

import com.example.clothingapp_frontend.screens.DiscoverScreen
import com.example.clothingapp_frontend.screens.DiscoverScreenWithState
import com.example.clothingapp_frontend.screens.LoginScreen
import com.example.clothingapp_frontend.screens.LoginScreenWithState
import com.example.clothingapp_frontend.screens.OnBordingScreen
import com.example.clothingapp_frontend.screens.OrderAcceptedScreen
import com.example.clothingapp_frontend.screens.SignUpScreenWithState
import com.example.clothingapp_frontend.screens.SneakerDetailScreen
import com.example.clothingapp_frontend.ui.theme.ClothingApp_FrontEndTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClothingApp_FrontEndTheme {
                    OnBordingScreen()
                   // LoginScreenWithState()
                    //SignUpScreenWithState()
                    //DiscoverScreenWithState()
                    //SneakerDetailScreen()
                    //CartScreen()
                    //CheckoutScreen()
                    //OrderAcceptedScreen()

            }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        OnBordingScreen()
        /*LoginScreenWithState()
        SignUpScreenWithState()
        DiscoverScreenWithState()
        SneakerDetailScreen()
        CartScreen()
        CheckoutScreen()
        OrderAcceptedScreen()*/



}
