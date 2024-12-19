package com.singlepointsol.assignment4
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var versionsArray: ArrayList<Version>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager= LinearLayoutManager(this)
        versionsArray=ArrayList()
        versionsArray.add(Version(R.drawable.rose,"Rose"))
        versionsArray.add(Version(R.drawable.pink,"jasmine"))
        versionsArray.add(Version(R.drawable.sun,"sunflower"))
        recyclerView.adapter=VersionsAdapter(versionsArray)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}