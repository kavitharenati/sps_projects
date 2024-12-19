package com.singlepointsol.recyclergrid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class VersionsImageAdapter(val versionsImageArray: Array<Int>) : RecyclerView.Adapter<VersionsImageAdapter.ViewHolder>() {
    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val versionImageView:ImageView=itemview.findViewById(R.id.version_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versionsImageArray.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.versionImageView.setImageResource(versionsImageArray[position])
        holder.versionImageView.setOnClickListener(View.OnClickListener {
            val intent=Intent(it.context,VersionsImageAdapter::class.java)
            intent.putExtra("name",Version.vName)
            intent.putExtra("name",Version.vImage)

            it.context.startActivity(intent)
        })
    }

}
