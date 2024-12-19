package com.singlepointsol.implicit

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var amazon: Button
    lateinit var flipkart: Button
    lateinit var meesho: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        amazon = findViewById(R.id.amazon_btn)
        flipkart = findViewById(R.id.flipkart_btn)
        meesho = findViewById(R.id.meesho_btn)
        //
        amazon.setOnClickListener(this)
        flipkart.setOnClickListener(this)
        meesho.setOnClickListener(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.amazon_btn -> {
                    val amazonIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com"))
                    startActivity(amazonIntent)
                }

                R.id.flipkart_btn -> {
                    val flipkartIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com"))
                    startActivity(flipkartIntent)
                }

                R.id.meesho_btn -> {
                    val meeshoIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.meesho.com"))
                    startActivity(meeshoIntent)
                }


            }
        }


    }
}

