package com.singlepointsol.assignment4

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Versiondetails : AppCompatActivity(){
    lateinit var selectedimage:ImageView
    lateinit var name_tv: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_versiondetails)
        selectedimage=findViewById(R.id.selected_imageView)
        name_tv=findViewById(R.id.nametextview)
        val imagePosition=intent.getIntExtra("vImage",100)
        selectedimage.setImageResource(imagePosition)
        name_tv.text=intent.getStringExtra("vName")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}