package com.singlepointsol.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "ProductDetailsDemo"
            ) {
                composable("ProductDetailsDemo") {
                    ProductDetailsDemo(navController)
                }
                composable("Details/{productname}/{productcolor}/{productprice}") { backStackEntry ->
                    val productname = backStackEntry.arguments?.getString("productname") ?: "N/A"
                    val productcolor = backStackEntry.arguments?.getString("productcolor") ?: "N/A"
                    val productprice = backStackEntry.arguments?.getString("productprice") ?: "N/A"
                    customerDetailsScreen(productname, productcolor, productprice )
                }
            }
        }
    }
}
