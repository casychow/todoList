package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calendar.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class calendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val launchFirstActivity = 2

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            val month = month + 1
            val msg = "You selected: $month/$day/$year"
            Toast.makeText(this@calendarActivity, msg, Toast.LENGTH_SHORT).show()
        }

        //Following lines are changes
        val returnIntent = Intent(this, MainActivity::class.java)
        setResult(Activity.RESULT_CANCELED, returnIntent)
        finish()

        calDone.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, launchFirstActivity)
        }
    }
}