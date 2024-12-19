package com.singlepointsol.passingvalues

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var value:TextView
    lateinit var homebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        value=findViewById(R.id.value_tv)
        homebtn=findViewById(R.id.home_btn)
        val myValue:String = intent.getStringExtra("data").toString()
        value.text=myValue
        homebtn.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val homeIntent: Intent = Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
    }
}