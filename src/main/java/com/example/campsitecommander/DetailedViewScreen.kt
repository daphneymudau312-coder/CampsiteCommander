package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        
        // Match the ID "main_layout" from activity_detailed_view_screen.xml
        val mainLayout = findViewById<android.view.View>(R.id.main_layout)
        if (mainLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Initialize UI components
        val tvDetails = findViewById<TextView>(R.id.tvChecklistDetails)
        val btnBack = findViewById<Button>(R.id.btnBackToBase)

        // Sample data for display
        val itemNames = arrayOf("tents", "flashlight", "cookies", "first aid")
        val categories = arrayOf("shelter", "safety", "food", "hospitality")
        val quantities = intArrayOf(2, 4, 3, 1)
        val comments = arrayOf("4 person waterproof", "check batteries", "large packet", "bug repellent")

        // Build the checklist summary
        val detailsBuilder = StringBuilder()
        for (i in itemNames.indices) {
            detailsBuilder.append("Item: ${itemNames[i]}\n")
            detailsBuilder.append("Category: ${categories[i]}\n")
            detailsBuilder.append("Quantity: ${quantities[i]}\n")
            detailsBuilder.append("Notes: ${comments[i]}\n")
            detailsBuilder.append("---------------------------\n")
        }

        tvDetails?.text = detailsBuilder.toString()

        // Back button to return to the previous screen
        btnBack?.setOnClickListener {
            finish()
        }
    }
}
