package com.example.pixabay

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.singlepointsol.pixabay.R
import com.squareup.picasso.Picasso

class ImageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        val imageUrl = intent.getStringExtra("imageUrl")
        val imageView: ImageView = findViewById(R.id.imageView)

        // Use Picasso to load the image into the ImageView
        Picasso.get().load(imageUrl).into(imageView)
    }
}
