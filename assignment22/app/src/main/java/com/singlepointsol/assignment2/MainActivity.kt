package com.singlepointsol.assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var goodMorningButton: Button
    lateinit var goodEveningButton: Button
    lateinit var goodNightButton: Button
    lateinit var parentLayout:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // loading of the
        goodMorningButton = findViewById(R.id.goodMorning_button)
        goodEveningButton = findViewById(R.id.goodEvening_button)
        goodNightButton = findViewById(R.id.goodNight_button)
        parentLayout = findViewById(R.id.main)

        goodMorningButton.setOnClickListener(this)
        goodEveningButton.setOnClickListener(this)
        goodNightButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id) {
                R.id.goodMorning_button -> parentLayout.setBackgroundResource(R.drawable.good_morning)
                R.id.goodEvening_button -> parentLayout.setBackgroundResource(R.drawable.good_evening)
                R.id.goodNight_button ->parentLayout.setBackgroundResource(R.drawable.good_night)
            }
        }
    }
}