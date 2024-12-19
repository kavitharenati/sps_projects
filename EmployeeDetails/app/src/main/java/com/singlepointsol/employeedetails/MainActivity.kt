package com.singlepointsol.employeedetails

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var employeeDetailsRecyclerView: RecyclerView
    private lateinit var employeeDetailsAdapter: EmployeeDetailsAdapter
    private lateinit var databaseReference: DatabaseReference
    private var employeeDetailsArrayList = ArrayList<EmployeeDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeDetailsRecyclerView = findViewById(R.id.EmployeeDetailsRecyclerView)
        employeeDetailsRecyclerView.layoutManager = LinearLayoutManager(this)
        employeeDetailsAdapter = EmployeeDetailsAdapter(employeeDetailsArrayList)
        employeeDetailsRecyclerView.adapter = employeeDetailsAdapter

        employeeDetailsArrayList = ArrayList()
        getEmployeeDetails()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val infater: MenuInflater =menuInflater
        infater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_menu -> {
                val employeeDetailsalertIntent = Intent(this, EmployeeDetailsAlert::class.java)
                startActivity(employeeDetailsalertIntent)
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getEmployeeDetails() {
        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeDetails")
        databaseReference.addValueEventListener(
            object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                employeeDetailsArrayList.clear()
                for (detailsSnapshot in snapshot.children) {
                    val details = detailsSnapshot.getValue(EmployeeDetails::class.java)
                    if (details != null) {
                        employeeDetailsArrayList.add(details)
                    }
                }
                employeeDetailsAdapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
