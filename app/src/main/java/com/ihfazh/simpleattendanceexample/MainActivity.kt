package com.ihfazh.simpleattendanceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.ihfazh.simpleattendanceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMore.setOnClickListener {
            openMoreMenu(it)
        }
        binding.eventsCard.setOnClickListener {
            Toast.makeText(this, "Events Card Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.studentsCard.setOnClickListener {
            Toast.makeText(this, "Students Card Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMoreMenu(view: View) {
        PopupMenu(this, view).apply {
            inflate(R.menu.more_button)
            setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.menu_event -> {
                        Toast.makeText(this@MainActivity, "Create event menu clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.menu_student -> {
                        Toast.makeText(this@MainActivity, "Create student menu clicked", Toast.LENGTH_SHORT).show()
                    }
                }

                true
            }
            show()
        }
    }
}