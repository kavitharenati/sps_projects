package com.singlepointsol.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singlepointsol.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // Set up NavController for navigation
                val navController = rememberNavController()

                // Set up NavHost with navigation routes
                NavHost(navController = navController, startDestination = "productDetailsScreen") {
                    composable("productDetailsScreen") {
                        ProductDetailsDemo(navController)
                    }
                    composable("productSummaryScreen/{name}/{details}/{price}/{color}") { backStackEntry ->
                        // Retrieve product details from the navigation arguments
                        val name = backStackEntry.arguments?.getString("name") ?: ""
                        val details = backStackEntry.arguments?.getString("details") ?: ""
                        val price = backStackEntry.arguments?.getString("price") ?: ""
                        val color = backStackEntry.arguments?.getString("color") ?: ""

                        // Display the product details in a new screen
                        ProductSummaryScreen(name, details, price, color)
                    }
                }
            }
        }
    }
}

