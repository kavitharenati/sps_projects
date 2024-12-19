package com.singlepointsol.sqlitelogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signinButton: Button
    lateinit var signupButton: Button
    lateinit var dbHelper: DBHelper
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.name_edit)
        passwordEditText = findViewById(R.id.password_edit)
        signinButton = findViewById(R.id.signin_btn)
        signupButton = findViewById(R.id.signup_btn)
        signinButton.setOnClickListener(this)
        signupButton.setOnClickListener(this)
        dbHelper = DBHelper(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?){
        if (v != null) {
            when (v.id) {
                R.id.signin_btn -> {

                    val intent = Intent(this, Welcomepage::class.java)
                    startActivity(intent)
                }

                R.id.signup_btn -> {
                    val intent = Intent(this, signup::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}
