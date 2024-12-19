package com.singlepointsol.sqlitelogin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signup : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var confirmEditText: EditText
    lateinit var signupButton: Button
    lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        nameEditText = findViewById(R.id.name_edit)
        phoneEditText = findViewById(R.id.phone_edit)
        emailEditText = findViewById(R.id.email_edit)
        confirmEditText = findViewById(R.id.confirm_edit)
        signupButton = findViewById(R.id.signup_btn)
        dbHelper=DBHelper(this)
        signupButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}