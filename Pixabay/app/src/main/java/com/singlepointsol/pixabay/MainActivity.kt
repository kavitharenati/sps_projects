package com.example.pixabay

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.pixabay.databinding.ActivityMainBinding
import com.example.pixabay.model.ImageItem
import com.example.pixabay.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageViewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize your RecyclerView adapter and layout manager here
        val adapter = ImageAdapter() // assuming you have a custom adapter for your RecyclerView
        binding.recyclerView.adapter = adapter

        // Observe the LiveData for images
        imageViewModel.images.observe(this, Observer { images ->
            if (images != null) {
                // Update RecyclerView with fetched data
                adapter.submitList(images)
            } else {
                Toast.makeText(this, "No images found", Toast.LENGTH_SHORT).show()
            }
        })

        // Trigger image search based on user input or some predefined query
        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            if (query.isNotEmpty()) {
                imageViewModel.fetchImages(query)
            } else {
                Toast.makeText(this, "Please enter a search query", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
