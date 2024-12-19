package com.singlepointsol.assignment4

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionsAdapter(private val versionsArray: ArrayList<Version>) : RecyclerView.Adapter<VersionsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val versionImage:ImageView=itemView.findViewById(R.id.image_view)
        val versionName:TextView=itemView.findViewById(R.id.text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val version=versionsArray[position]
        holder.versionName.text=version.vName
        holder.versionImage.setImageResource(version.vImage)

        holder.versionImage.setOnClickListener {
            val intent = Intent(it.context, Versiondetails::class.java)
            intent.putExtra("vName", version.vName)
            intent.putExtra("vImage", version.vImage)

            it.context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {
        return versionsArray.size


    }

}
