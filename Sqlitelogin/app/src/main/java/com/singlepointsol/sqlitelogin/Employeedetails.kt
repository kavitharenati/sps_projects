package com.singlepointsol.sqlitelogin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Employeedetails : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dbHelper: DBHelper
    private lateinit var employeesArrayList: ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employeedetails)
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager= LinearLayoutManager(this)
        dbHelper=DBHelper(this)
        employeesArrayList=dbHelper.getemployees()
        recyclerView.adapter=EmployeesAdapter(employeesArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}