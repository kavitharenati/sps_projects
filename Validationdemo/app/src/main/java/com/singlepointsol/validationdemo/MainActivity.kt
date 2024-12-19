package com.singlepointsol.validationdemo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signinButton:Button
    lateinit var signupButton: Button
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        usernameEditText=findViewById(R.id.username_edit)
        passwordEditText=findViewById(R.id.password_edit)
        signinButton=findViewById(R.id.signin_btn)
        signupButton=findViewById(R.id.signup_btn)
        signinButton.setOnClickListener(this)
        signupButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?){
        if(view!=null){
            when(view.id){
                R.id.signin_btn->{
                    if(sharedPrefs.contains("nameKey") && sharedPrefs.contains("passwordkey"))
                    {
                        usernameEditText=sharedPrefs.getString("nameKey",null)
                        passwordEditText=sharedPrefs.getString("passwordkey",null)

                    }
                    if(usernameEditText.text.toString().isEmpty() || passwordEditText.toString().isEmpty()){
                        Toast.makeText(this,"Enter username & password!",Toast.LENGTH_LONG)
                    }
                    else if(usernameEditText.text.toString() == username && passwordEditText.text.toString()==password
                    ){
                            val welcomepageintent=Intent(this,Welcomepage::class.java)
                            startActivity(welcomepageintent)
                    }else {
                        Toast.makeText(this, "Invalid user", Toast.LENGTH_LONG)

                    }

                }
                R.id.signup_btn->{
                    val welcomepageintent=Intent(this,Signup::class.java)
                    startActivity(welcomepageintent)
                }

            }
        }

    }
}