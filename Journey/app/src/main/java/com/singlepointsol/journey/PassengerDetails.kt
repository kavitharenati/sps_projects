package com.singlepointsol.journey

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

 class PassengerDetails : AppCompatActivity(),OnClickListener {

    lateinit var profile:TextView
    lateinit var source:TextView
    lateinit var destination:TextView
    lateinit var date:TextView
    lateinit var time:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_passenger_details)
        //load views
        profile=findViewById(R.id.profile_tv)
        source=findViewById(R.id.source_tv)
        destination=findViewById(R.id.destination_tv)
        date=findViewById(R.id.date_tv)
        time=findViewById(R.id.time_tv)
        //preceive key from main activity
        val fromValue: String = intent.getStringExtra("source").toString()
        val toValue: String = intent.getStringExtra("destination").toString()
        val dateValue:String=intent.getStringExtra("date").toString()
        val pickupValue:String=intent.getStringExtra("time").toString()
        source.text = fromValue
        destination.text = toValue
        date.text=dateValue
        time.text=pickupValue
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
     override fun onClick(v: View?){
         val intent=Intent(this,PassengerDetails::class.java)
         startActivity(intent)
    }
}
