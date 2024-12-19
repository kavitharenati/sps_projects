package com.singlepointsol.sqlitelogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeesAdapter(val employeesArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name_tv)
        val email:TextView=itemView.findViewById(R.id.email_tv)
        val phone:TextView=itemView.findViewById(R.id.phone_tv)
        val confirmpassword:TextView=itemView.findViewById(R.id.confirm_password)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.emp_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeesAdapter.ViewHolder, position: Int) {
        val employee = employeesArrayList[position]
        holder.name.text=employee.name
        holder.phone.text=employee.phone
        holder.email.text=employee.email
        holder.confirmpassword.text=employee.confirmpassword

    }

    override fun getItemCount(): Int {
        return employeesArrayList.size

    }

}

