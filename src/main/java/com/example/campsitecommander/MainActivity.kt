package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Data arrays
        val itemNames = arrayOf("tents", "flashlight", "cookies", "first aid")
        val categories = arrayOf("shelter", "safety", "food", "hospitality")
        val quantities = intArrayOf(2, 4, 3, 1)

        var totalItems = 0
        for (q in quantities) {
            totalItems += q
        }

        // Find views
        val totalItemsTextView = findViewById<TextView>(R.id.totalitemsTextView)
        val viewDetailsButton = findViewById<Button>(R.id.ViewDetailsButton)
        val backButton = findViewById<Button>(R.id.BackButton)

        // Show items and categories in the summary text
        val itemsList = itemNames.joinToString(", ")
        val categoriesList = categories.distinct().joinToString(", ")
        
        totalItemsTextView.text = "Packed Gear: $totalItems\n\nItems:\n$itemsList\n\nCategories:\n$categoriesList"

        // Navigate to the Detailed View
        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        // Return to the Splash Screen
        backButton.setOnClickListener {
            finish()
        }
    }
}
