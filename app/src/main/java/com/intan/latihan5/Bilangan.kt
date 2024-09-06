package com.intan.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bilangan : AppCompatActivity() {
    private lateinit var btnhasil : Button
    private lateinit var txthasil : TextView
    private lateinit var etbilangan : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bilangan)

        btnhasil = findViewById(R.id.btnhasil)
        txthasil = findViewById(R.id.txthasil)
        etbilangan = findViewById(R.id.etbilangan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnhasil.setOnClickListener {
            val input = etbilangan.text.toString().toIntOrNull() // Get input and convert to Integer

            if (input != null) {
                val result = if (input % 2 == 0) "Bilangan genap" else "Bilangan ganjil"
                txthasil.text = result // Display the result
            } else {
                txthasil.text = "Input tidak valid!"
            }
        }
    }
}
