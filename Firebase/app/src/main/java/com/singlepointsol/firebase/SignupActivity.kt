package com.singlepointsol.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.singlepointsol.firebase.SigninActivity

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEt: EditText
    lateinit var emailEt: EditText
    lateinit var passwordEt: EditText
    lateinit var confirmpasswordEt: EditText
    lateinit var signupBtn: Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        //loadviewss into activity
        nameEt = findViewById(R.id.name_editText)
        emailEt = findViewById(R.id.email_editText)
        passwordEt = findViewById(R.id.password_editText)
        confirmpasswordEt = findViewById(R.id.confirmpassword_editText)
        signupBtn = findViewById(R.id.signup_button)
        auth = Firebase.auth

        //set listeners
        signupBtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val name = nameEt.text.toString()
        val email = emailEt.text.toString()
        val password = passwordEt.text.toString()
        val confirmPassword = confirmpasswordEt.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password == confirmPassword) {


                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    val intent = Intent(this, SigninActivity::class.java)
                    startActivity(intent)
                    if (it.isSuccessful) {
                        nameEt.text.clear()
                        emailEt.text.clear()
                        passwordEt.text.clear()
                        confirmpasswordEt.text.clear()
                    } else {
                        Toast.makeText(this, "Unable to signup", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}