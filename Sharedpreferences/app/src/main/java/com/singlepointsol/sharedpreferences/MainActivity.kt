package com.singlepointsol.sharedpreferences

import android.annotation.SuppressLint
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

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loadBtn:Button
    lateinit var saveBtn:Button
    lateinit var sharedPrefs:SharedPreferences
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEditText=findViewById(R.id.name_et)
        passwordEditText=findViewById(R.id.password_et)
        loadBtn=findViewById(R.id.load_btn)
        saveBtn=findViewById(R.id.save_btn)
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
         sharedPrefs=getSharedPreferences("single point solutions",MODE_PRIVATE)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                R.id.save_btn->{
                  val editor:SharedPreferences.Editor=sharedPrefs.edit()
                    editor.putString("nameKey",nameEditText.toString())
                    editor.putString("passwordkey",passwordEditText.toString())
                    editor.apply()
                    nameEditText.text.clear()
                    passwordEditText.text.clear()
                }
                R.id.load_btn->{
                    if(sharedPrefs.contains("nameKey")){
                        val name:String=sharedPrefs.getString("nameKey",null).toString()
                        nameEditText.setText(name)
                    }
                    else{
                        Toast.makeText(this,"Empty name preference",Toast.LENGTH_LONG).show()
                    }
                    if(sharedPrefs.contains("passwordkey")){
                        val password:String=sharedPrefs.getString("passwordkey",null).toString()
                        passwordEditText.setText(password)
                    }
                    else{
                        Toast.makeText(this,"Empty password preference",Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }
}