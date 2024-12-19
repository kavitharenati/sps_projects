package com.singlepointsol.buttons

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var goodMorningButton: Button
    lateinit var goodEveningButton: Button
    lateinit var goodNightButton: Button
    lateinit var parentLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
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
}


}
