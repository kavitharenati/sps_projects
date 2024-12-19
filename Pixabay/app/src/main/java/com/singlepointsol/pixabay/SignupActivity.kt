package com.singlepointsol.pixabay

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pixabay.database.User
import com.example.pixabay.database.UserDatabase
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_button.setOnClickListener {
            val username = username_edit_text.text.toString()
            val password = password_edit_text.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val user = User(username = username, password = password)

                // Save the user in the Room database
                lifecycleScope.launch {
                    val db = UserDatabase.getDatabase(applicationContext)
                    db.userDao().insert(user)
                    Toast.makeText(this@SignupActivity, "Signup Successful", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
