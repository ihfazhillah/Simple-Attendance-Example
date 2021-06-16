package com.ihfazh.simpleattendanceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ihfazh.simpleattendanceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMore.setOnClickListener {
            Toast.makeText(this, "Button More Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.eventsCard.setOnClickListener {
            Toast.makeText(this, "Events Card Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.studentsCard.setOnClickListener {
            Toast.makeText(this, "Students Card Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}