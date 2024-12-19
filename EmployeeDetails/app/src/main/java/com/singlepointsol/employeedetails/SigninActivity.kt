package com.singlepointsol.employeedetails

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signinBtn: Button
    lateinit var signupBtn: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Initialize views
        emailEditText = findViewById(R.id.email_et)
        passwordEditText = findViewById(R.id.password_et)
        signinBtn = findViewById(R.id.signin_button)
        signupBtn = findViewById(R.id.signup_button)

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Set click listeners
        signinBtn.setOnClickListener(this)
        signupBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signin_button -> {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                // Validate fields
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    // Attempt sign-in with Firebase
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign-in successful
                                Toast.makeText(this, "Sign-in successful", Toast.LENGTH_SHORT).show()

                                // Navigate to MainActivity
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish() // Close SigninActivity so the user can't return back
                            } else {
                                // Show error message
                                Toast.makeText(
                                    this,
                                    "Unable to sign in: ${task.exception?.message}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                } else {
                    // Display a message if fields are empty
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
                }
            }

            R.id.signup_button -> {
                // Navigate to SignupActivity
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
