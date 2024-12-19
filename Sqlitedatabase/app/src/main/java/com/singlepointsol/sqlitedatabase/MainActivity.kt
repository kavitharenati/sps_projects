package com.singlepointsol.sqlitedatabase

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
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
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveBtn: Button
    private lateinit var loadBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var dbHelper: DBHelper
    private lateinit var colIDEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.name_edit)
        phoneEditText = findViewById(R.id.phone_edit)
        emailEditText = findViewById(R.id.email_edit)
        saveBtn = findViewById(R.id.save_btn)
        loadBtn = findViewById(R.id.load_btn)
        colIDEditText=findViewById(R.id.col_id)
        updateBtn = findViewById(R.id.update_btn)
        deleteBtn = findViewById(R.id.delete_btn)
        saveBtn.setOnClickListener(this)
        loadBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        dbHelper = DBHelper(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.save_btn -> {
                    if (nameEditText.text.isNotEmpty() && emailEditText.text.isNotEmpty() && phoneEditText.text.isNotEmpty()){

                    val employee = Employee(
                        nameEditText.text.toString(),
                        emailEditText.text.toString(),
                        phoneEditText.text.toString()
                    )
                    val result= dbHelper.addEmployee(employee)
                    if (result >= -1) {
                        Toast.makeText(applicationContext, "Data Inserted!", Toast.LENGTH_LONG)
                            .show()
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        phoneEditText.text.clear()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "name or email or phone should not be blank",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }

            R.id.load_btn->{
                intent=Intent(this,Employeedetails::class.java)
                startActivity(intent)


            }
            R.id.update_btn->{
                val isUpdated:Boolean=dbHelper.updateEmployee(colIDEditText.toString(),nameEditText.toString(),emailEditText.toString(),phoneEditText.toString())
                if(isUpdated)
                {
                    Toast.makeText(applicationContext,"data updated",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(applicationContext,"data not found",Toast.LENGTH_LONG).show()
                }
            }
            R.id.delete_btn->{
                val rows = dbHelper.deleteEmployee(colIDEditText.text.toString())
                if(rows>0)
                {
                    Toast.makeText(applicationContext,"Data deleted successfully",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()

                }
            }

        }
    }
}
}