package com.singlepointsol.loginform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetails : AppCompatActivity(), View.OnClickListener {
    lateinit var name: TextView
    lateinit var phone: TextView
    lateinit var email: TextView
    lateinit var designation: TextView
    lateinit var homebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_details)
        name = findViewById(R.id.name_tv)
        phone = findViewById(R.id.phone_tv)
        email = findViewById(R.id.email_tv)
        designation = findViewById(R.id.data_tv)
        homebtn = findViewById(R.id.home_btn)
        val myValue: String = intent.getStringExtra("name").toString()
        val myid: String = intent.getStringExtra("phone").toString()
        val mydata: String = intent.getStringExtra("email").toString()
        val myset: String = intent.getStringExtra("designation").toString()
        name.text = myValue
        phone.text = myid
        email.text = mydata
        designation.text = myset
        homebtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val homeIntent: Intent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)

    }
}