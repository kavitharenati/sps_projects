package com.singlepointsol.navigation



import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase

@Composable
fun ProductDetailsDemo(navController: NavController) {
    var productname by remember { mutableStateOf(TextFieldValue("")) }
    var productcolor by remember { mutableStateOf(TextFieldValue("")) }
    var productprice by remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current // Ensuring context is available

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter customer Details")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productname,
            onValueChange = { productname = it },
            label = { Text(text = "productname")  },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productcolor,
            onValueChange = { productcolor = it },
            label = { Text(text = "productcolor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = productprice,
            onValueChange = { productprice = it },
            label = { Text(text = "productprice") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (productname.text.isNotEmpty() && productcolor.text.isNotEmpty() && productprice.text.isNotEmpty()) {
                    saveDataToFirebase(productname.text, productcolor.text, productprice.text, context) {

                        navController.navigate("Details/${productname.text}/${productcolor.text}/${productprice.text}")
                    }
                } else {
                    Toast.makeText(context, "Please fill all details", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

fun saveDataToFirebase(productname: String, productcolor: String, productprice: String, context: Context, onSuccess: () -> Unit) {
    val database = FirebaseDatabase.getInstance()
    val reference = database.reference.child("Productitem")

    val userId = reference.push().key
    val ProuctItem = ProuctItem(productname, productcolor, productprice)

    if (userId != null) {
        reference.child(userId).setValue(ProuctItem).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Data added successfully", Toast.LENGTH_SHORT).show()
                onSuccess()
            } else {
                Toast.makeText(context, "Unable to fetch data: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}