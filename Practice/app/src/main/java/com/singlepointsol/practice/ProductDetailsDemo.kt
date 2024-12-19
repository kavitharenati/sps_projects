package com.singlepointsol.practice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.google.firebase.database.*
import com.singlepointsol.practice.ui.theme.PracticeTheme

@Composable
fun ProductDetailsDemo(navController: NavController, modifier: Modifier = Modifier) {
    var productName by remember { mutableStateOf(TextFieldValue()) }
    var productDetails by remember { mutableStateOf(TextFieldValue()) }
    var productPrice by remember { mutableStateOf(TextFieldValue()) }
    var productColor by remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    // Firebase reference
    val database = FirebaseDatabase.getInstance()
    val databaseReference = database.getReference("Product")

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Add Product Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Input fields
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productDetails,
            onValueChange = { productDetails = it },
            label = { Text("Product Details") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productColor,
            onValueChange = { productColor = it },
            label = { Text("Color") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Push data to Firebase Realtime Database
                val product = mapOf(
                    "name" to productName.text,
                    "details" to productDetails.text,
                    "price" to productPrice.text,
                    "color" to productColor.text
                )
                databaseReference.push().setValue(product)
                    .addOnSuccessListener {
                        Toast.makeText(
                            context,
                            "Item added successfully!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Navigate to the summary screen with the entered details
                        navController.navigate("productSummaryScreen/${productName.text}/${productDetails.text}/${productPrice.text}/${productColor.text}")
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            context,
                            "Failed to add item.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))



                    }
                }





@Composable
fun ProductSummaryScreen(name: String, details: String, price: String, color: String) {
    // Vertical Grid displaying the product details
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Product Summary Screen ", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Name: $name", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Details: $details", style = MaterialTheme.typography.bodySmall)
        Text(text = "Price: $price", style = MaterialTheme.typography.bodySmall)
        Text(text = "Color: $color", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

