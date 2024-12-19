package com.singlepointsol.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.api.databinding.ActivityMainBinding

import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var natureArrayList: ArrayList<Nature>
    private lateinit var natureAdapter: NatureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        natureArrayList = arrayListOf()
        natureAdapter = NatureAdapter(natureArrayList)
        binding.recyclerView.adapter = natureAdapter

        // Fetch nature data from API
        fetchNatureData()
    }

    private fun fetchNatureData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.getRetrofitInstance()
                    .create(ApiService::class.java)
                    .getNature()

                if (response.isSuccessful) {
                    val natureList = response.body()?.hits ?: emptyList()

                    // Update RecyclerView data on the Main thread
                    withContext(Dispatchers.Main) {
                        natureArrayList.clear()
                        natureArrayList.addAll(natureList)
                        natureAdapter.notifyDataSetChanged()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Handle unsuccessful response
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Log or display an error message
                }
            }
        }
    }
}
