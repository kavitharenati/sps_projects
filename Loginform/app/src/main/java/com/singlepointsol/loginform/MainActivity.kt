package com.singlepointsol.loginform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var designationEditText: EditText
    lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.name_edit)
        phoneEditText = findViewById(R.id.phone_edit)
        emailEditText = findViewById(R.id.email_edit)
        designationEditText = findViewById(R.id.designation_edit)
        submitButton = findViewById(R.id.submit_btn)
        submitButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, ProfileDetails::class.java)
        intent.putExtra("name", nameEditText.text.toString())
        intent.putExtra("phone", phoneEditText.text.toString())
        intent.putExtra("email", emailEditText.text.toString())
        intent.putExtra("designation", designationEditText.text.toString())
        startActivity(intent)
    }
}