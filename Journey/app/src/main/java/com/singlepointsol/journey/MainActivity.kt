package com.singlepointsol.journey

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    lateinit var sourceEditText: EditText
    lateinit var destinationEditText: EditText
    lateinit var dateButton: Button
    lateinit var timeButton: Button
    lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sourceEditText = findViewById(R.id.source_edit)
        destinationEditText = findViewById(R.id.destination_edit)
        dateButton = findViewById(R.id.date_btn)
        timeButton = findViewById(R.id.time_btn)
        submitButton = findViewById(R.id.submit_btn)
        dateButton.setOnClickListener(this)
        timeButton.setOnClickListener(this)
        submitButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val c = Calendar.getInstance()
        val hour: Int = c.get(Calendar.HOUR_OF_DAY)
        val minute: Int = c.get(Calendar.MINUTE)
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day_of_month = c.get(Calendar.DAY_OF_MONTH)


        if (v != null) {
            when (v.id) {
                R.id.time_btn -> {
                    TimePickerDialog(this, this, hour, minute, true).show()
                }

                R.id.date_btn -> {
                    DatePickerDialog(this, this, year, month, day_of_month).show()
                }

                R.id.submit_btn -> {
                    val intent = Intent(this, PassengerDetails::class.java)
                    intent.putExtra("source", sourceEditText.text.toString())
                    intent.putExtra("destination", destinationEditText.text.toString())
                    intent.putExtra("date", dateButton.text.toString()) // Pass selected date
                    intent.putExtra("time", timeButton.text.toString()) // Pass selected time
                    startActivity(intent)
                }
            }
        }
    }


    override fun onTimeSet(v: TimePicker?, v1: Int, v2: Int) {
        val timeselected = "$v1:$v2"
        timeButton.text = timeselected

    }

    override fun onDateSet(v: DatePicker?, v1: Int, v2: Int, v3: Int) {
        val dateselected = "${v2 + 1}/$v3/$v1"
        dateButton.text = dateselected
    }
}
