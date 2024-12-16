package com.singlepointsol.api

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NatureAdapter(private val natureArrayList: ArrayList<Nature>) :
    RecyclerView.Adapter<NatureAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val natureImage: ImageView = itemView.findViewById(R.id.naturelist_image)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val viewCount: TextView = itemView.findViewById(R.id.view_count)
        val downloadCount: TextView = itemView.findViewById(R.id.download_count)
        val likesCount: TextView = itemView.findViewById(R.id.likes_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nature_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = natureArrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nature = natureArrayList[position]

        // Load the image using Glide
        Glide.with(holder.itemView.context).load(nature.natureImage).into(holder.natureImage)

        // Set the text values
        holder.userName.text = "User: ${nature.user}"
        holder.viewCount.text = "Views: ${nature.views}"
        holder.downloadCount.text = "Downloads: ${nature.downloads}"
        holder.likesCount.text = "Likes: ${nature.likes}"

        // Pass data to NatureActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NatureActivity::class.java).apply {
                putExtra("natureImage", nature.natureImage)
                putExtra("user", nature.user)
                putExtra("views", nature.views)
                putExtra("downloads", nature.downloads)
                putExtra("likes", nature.likes)
            }
            holder.itemView.context.startActivity(intent)
        }
    }
}
