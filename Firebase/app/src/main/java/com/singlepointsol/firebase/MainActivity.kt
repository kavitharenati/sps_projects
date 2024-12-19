package com.singlepointsol.firebase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


abstract class MainActivity : AppCompatActivity(), EmployeeAlert.OnEmployeeDataEnteredListener {

    private lateinit var employeeRecyclerView: RecyclerView
    private var  employeeArrayList = ArrayList<Employee>()
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        employeeRecyclerView = findViewById(R.id.employeeRecyclerView)
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter and set it to RecyclerView
        employeeAdapter = EmployeeAdapter(employeeArrayList)
        employeeRecyclerView.adapter = employeeAdapter
    }

    // Inflate the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_menu -> {

                EmployeeAlert().show(supportFragmentManager,"add item")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onEmployeeDataEntered(name: String, id: String, mbl: String, address: String) {

        val newEmployee = Employee(name, id, mbl, address)
        employeeArrayList.add(newEmployee)
        employeeAdapter.notifyItemInserted(employeeArrayList.size - 1)

        Toast.makeText(this, "Details added successfully", Toast.LENGTH_SHORT).show()
    }
}
