package com.singlepointsol.firebase

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class EmployeeAlert : DialogFragment() {

    interface OnEmployeeDataEnteredListener {
        fun onEmployeeDataEntered(name: String, id: String, mbl: String, address: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())

        // Inflate the dialog layout
        val inflater = LayoutInflater.from(requireContext())
        val view: View = inflater.inflate(R.layout.employee_alert, null)

        // Initialize views from the custom layout
        val nameEditText: EditText = view.findViewById(R.id.employeeName_editText)
        val idEditText: EditText = view.findViewById(R.id.employeeId_editText)
        val mblEditText: EditText = view.findViewById(R.id.employeeMbl_editText)
        val addressEditText: EditText = view.findViewById(R.id.employeeAddress_editText)
        val addButton: Button = view.findViewById(R.id.add_Btn)

        dialog.setContentView(view)

        // Set listener to add button
        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val mbl = mblEditText.text.toString()
            val address = addressEditText.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty() && mbl.isNotEmpty() && address.isNotEmpty()) {
                // Pass data back to the activity using the listener
                val listener = activity as? OnEmployeeDataEnteredListener
                listener?.onEmployeeDataEntered(name, id, name, address)
                dialog.dismiss()
            } else {
                Toast.makeText(context,"Fill all the fields",Toast.LENGTH_SHORT).show()
            }
        }

        return dialog
    }
}

