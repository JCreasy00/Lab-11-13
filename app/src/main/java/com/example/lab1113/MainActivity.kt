package com.example.lab1113

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonStart = findViewById<Button>(R.id.buttonStart)

        buttonStart.setOnClickListener {
            val intent = Intent(this, CountdownService::class.java)
            intent.putExtra("COUNTDOWN_VALUE", editTextNumber.text.toString().toIntOrNull() ?: 0)
            startService(intent)
        }
    }
}
