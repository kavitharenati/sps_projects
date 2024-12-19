package com.singlepointsol.assignment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    lateinit var nameEdit:EditText
    lateinit var phoneEdit: EditText
    lateinit var emailEdit: EditText
    lateinit var designationEdit: EditText
    lateinit var submitBtn: Button
    lateinit var nameText: TextView
    lateinit var phoneText: TextView
    lateinit var emailText: TextView
    lateinit var designationText: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        nameEdit=findViewById(R.id.name_edit)
        phoneEdit=findViewById(R.id.phone_edit)
        emailEdit=findViewById(R.id.email_edit)
        designationEdit=findViewById(R.id.designation_edit)
        submitBtn=findViewById(R.id.submit_btn)
        nameText=findViewById(R.id.name_tv)
        phoneText=findViewById(R.id.phone_tv)
        emailText=findViewById(R.id.email_tv)
        designationText=findViewById(R.id.data_tv)

        submitBtn.setOnClickListener(View.OnClickListener {
            nameText.text = nameEdit.text
            phoneText.text=phoneEdit.text
            emailText.text=emailEdit.text
            designationText.text=designationEdit.text
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}