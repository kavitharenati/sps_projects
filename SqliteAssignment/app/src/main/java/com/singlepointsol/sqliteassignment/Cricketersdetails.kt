package com.singlepointsol.sqliteassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cricketersdetails : AppCompatActivity(){
    private lateinit var recyclerView:RecyclerView
    private lateinit var dbHelper:DBHelper
    private lateinit var cricketersArrayList:ArrayList<Cricketer>
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cricketersdetails)
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager= LinearLayoutManager(this)
        dbHelper=DBHelper(this)
        cricketersArrayList=dbHelper.getcricketers()
        recyclerView.adapter=CricketersAdapter(cricketersArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){ v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom)
            insets
        }
    }
}