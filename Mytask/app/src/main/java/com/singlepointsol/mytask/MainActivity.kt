package com.singlepointsol.mytask

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var nameEdit:EditText
    lateinit var phoneEdit:EditText
    lateinit var submitbtn:Button
    lateinit var nameText:TextView
    lateinit var phoneText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEdit=findViewById(R.id.name_edit)
        phoneEdit=findViewById(R.id.phone_edit)
        submitbtn=findViewById(R.id.submit_btn)
        nameText=findViewById(R.id.name_tv)
        phoneText=findViewById(R.id.phone_tv)

        submitbtn.setOnClickListener(View.OnClickListener {
            nameText.text=nameEdit.text
            phoneText.text=phoneEdit.text
        })



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}