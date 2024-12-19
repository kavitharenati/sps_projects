package com.singlepointsol.readingvalues

import android.icu.text.Edits
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
    lateinit var dataEdit:EditText
    lateinit var submitBtn:Button
    lateinit var valueTxt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            dataEdit =findViewById(R.id.data_edit)
            submitBtn =findViewById(R.id.submit_btn)
            valueTxt =findViewById(R.id.data_edit)

        submitBtn.setOnClickListener(View.OnClickListener {
            val value:String= dataEdit.text.toString()
            valueTxt.text=value
            dataEdit.setText("")
        })

        

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}