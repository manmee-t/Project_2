package com.example.practice


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val l1 = mutableListOf<String>(
            "Manmeet",
            "Priyanshu",
            "Sourav",
            "Arpit"
        )
        val textView = findViewById<TextView>(R.id.textView)
        val listItem = findViewById<TextView>(R.id.textView2)
        val add = findViewById<EditText>(R.id.editTextView1)
        val num = findViewById<EditText>(R.id.editTextNumber)
        val btn = findViewById<Button>(R.id.button)
        listItem.setText(l1.toString())
        num.setOnEditorActionListener { _, _, _ ->
            val input = num.text.toString()
            val index = input.toIntOrNull()
            if (index != null && index in l1.indices) {
                textView.setText(l1[index])
            } else {
                textView.setText("Invalid Input")
            }
            true
        }
        btn.setOnClickListener {
            val input = add.text.toString()
            l1.add(input)
            add.setText("")
            listItem.setText(l1.toString())
            Toast.makeText(this, "You added $input", Toast.LENGTH_SHORT).show()
        }
    }
}
