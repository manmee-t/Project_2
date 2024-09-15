package com.example.practice


import android.os.Bundle
import android.widget.EditText
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
        val l1 = listOf(
            "Manmeet",
            "Priyanshu",
            "Sourav",
            "Arpit"
        )
        val textView = findViewById<TextView>(R.id.textView)
        val num = findViewById<EditText>(R.id.editTextNumber)
        num.setOnEditorActionListener {
            _, _, _ ->
            val input = num.text.toString()
            val index = input.toIntOrNull()
            if (index != null && index in l1.indices) {
                textView.setText(l1[index])
            }else{
                textView.setText("Invalid Input")
            }
            true
        }
    }

   // fun input(p0: EditText) {}
}

/*fun number(num:Int=0): Int{
    val input = readln().toInt()
    return input
}*/