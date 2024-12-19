package com.singlepointsol.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Details : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productname = intent.getStringExtra("productname") ?: ""
        val productcolor = intent.getStringExtra("productcolor") ?: ""
        val productprice = intent.getStringExtra("productprice") ?: ""

        setContent {
            customerDetailsScreen(productname, productcolor, productprice)
        }
    }
}

@Composable
fun customerDetailsScreen(productname: String, productcolor: String, productprice: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "User Details", style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp))
        Text(text = "productame: $productname")
        Text(text = "productcolor: $productcolor")
        Text(text = "productprice: $productprice")
    }
}
