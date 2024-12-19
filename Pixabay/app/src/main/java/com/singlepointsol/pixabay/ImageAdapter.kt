package com.singlepointsol.pixabay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ImageAdapter(private val images: List<ImageItem>, private val onClick: (ImageItem) -> Unit) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        Picasso.get().load(image.webformatURL).into(holder.imageView)
        holder.itemView.setOnClickListener { onClick(image) }
    }

    override fun getItemCount() = images.size

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
    }

    // This method is used to update the images in the adapter
    fun submitList(newImages: List<ImageItem>) {
        (images as MutableList).clear()
        images.addAll(newImages)
        notifyDataSetChanged()
    }
}
