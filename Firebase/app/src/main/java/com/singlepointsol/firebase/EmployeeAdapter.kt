package com.singlepointsol.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeeArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.employee_name)
        val idTextView: TextView = itemView.findViewById(R.id.employee_id)
        val mblTextView: TextView = itemView.findViewById(R.id.employee_mbl)
        val addressTextView: TextView = itemView.findViewById(R.id.employee_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_employee,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val employee = employeeArrayList[position]
        holder.nameTextView.text = " Employee Name:${employee.name}"
        holder.idTextView.text = "Employee Id:${employee.id}"
        holder.mblTextView.text = "Employee Mbl:${employee.mbl}"
        holder.addressTextView.text ="Employee Address:${employee.address}"
    }

    override fun getItemCount(): Int = employeeArrayList.size
}
