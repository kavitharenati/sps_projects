package com.singlepointsol.employeedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeDetailsAdapter(private val EmployeeDetailsArrayList: ArrayList<EmployeeDetails>) : RecyclerView.Adapter<EmployeeDetailsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.employeename_tv)
        val idTextView: TextView = itemView.findViewById(R.id.employeeid_tv)
        val mblTextView: TextView = itemView.findViewById(R.id.employeembl_tv)
        val addressTextView: TextView = itemView.findViewById(R.id.address_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.details_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return EmployeeDetailsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val details = EmployeeDetailsArrayList[position]
        holder.nameTextView.text=details.employeeName
        holder.idTextView.text=details.employeeId
        holder.mblTextView.text=details.employeeMbl
        holder.addressTextView.text=details.address
    }

}

