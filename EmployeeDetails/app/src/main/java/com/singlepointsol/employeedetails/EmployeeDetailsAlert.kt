package com.singlepointsol.employeedetails

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EmployeeDetailsAlert : DialogFragment() {
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.activity_employee_detailsalert, null)

        val nameEditText = view.findViewById<EditText>(R.id.employeename_et)
        val idEditText = view.findViewById<EditText>(R.id.employeeid_et)
        val mblEditText = view.findViewById<EditText>(R.id.employeembl_et)
        val addressEditText = view.findViewById<EditText>(R.id.employeeaddress_et)
        val addButton = view.findViewById<Button>(R.id.add_button)

        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference.child("EmployeeDetails")

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val mbl = mblEditText.text.toString()
            val address = addressEditText.text.toString()

            // Check if all fields are filled
            if (name.isNotEmpty() && id.isNotEmpty() && mbl.isNotEmpty() && address.isNotEmpty()) {
                val employee = EmployeeDetails(name, id, mbl, address)

                databaseReference.push().setValue(employee)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Employee added successfully!", Toast.LENGTH_SHORT).show()
                        dismiss()
                    }
                    .addOnFailureListener {
                        Toast.makeText(requireContext(), "Failed to add employee", Toast.LENGTH_SHORT).show()
                    }
                // Handle case where fields are empty
                nameEditText.error = "Enter a name"
                idEditText.error = "Enter an ID"
                mblEditText.error = "Enter a mobile number"
                addressEditText.error = "Enter a address"
            }
        }

        builder.setView(view)
        return builder.create()
    }
}
