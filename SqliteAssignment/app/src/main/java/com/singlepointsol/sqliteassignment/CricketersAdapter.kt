package com.singlepointsol.sqliteassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketersAdapter(val cricketersArrayList:ArrayList<Cricketer>) : RecyclerView.Adapter<CricketersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name_tv)
        val teamname:TextView=itemView.findViewById(R.id.team_name_tv)
        val category:TextView=itemView.findViewById(R.id.category_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketersAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cri_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CricketersAdapter.ViewHolder, position: Int) {
        val cricketer = cricketersArrayList[position]
        holder.name.text=cricketer.name
        holder.teamname.text=cricketer.teamname
        holder.category.text=cricketer.category

    }

    override fun getItemCount(): Int {
        return cricketersArrayList.size

    }

}

