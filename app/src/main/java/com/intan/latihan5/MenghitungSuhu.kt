package com.intan.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenghitungSuhu : AppCompatActivity() {
    private lateinit var btnk: Button
    private lateinit var btnramour: Button
    private lateinit var btnf: Button
    private lateinit var etbilcelcius: EditText
    private lateinit var txthasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menghitung_suhu)

        btnk = findViewById(R.id.btnk)
        btnf = findViewById(R.id.btnf)
        btnramour = findViewById(R.id.btnreamor)
        etbilcelcius = findViewById(R.id.etbilcelcius)
        txthasil = findViewById(R.id.txthasil)

        btnf.setOnClickListener {
            val hasil = etbilcelcius.text.toString()
            if (hasil.isEmpty()) {
                Toast.makeText(this, "Masukkan suhu dalam Celsius", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val celsius = hasil.toDouble()
            val fahrenheit = (9.0 / 5.0) * celsius + 32
            txthasil.text = "Fahrenheit: %.2f".format(fahrenheit)
        }
        btnk.setOnClickListener {
            val celsiusStr = etbilcelcius.text.toString()

            if (celsiusStr.isEmpty()) {
                Toast.makeText(this, "Masukkan suhu dalam Celsius", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val celsius = celsiusStr.toDouble()
            val kelvin = celsius + 273.15

            txthasil.text = "Kelvin: %.2f".format(kelvin)
        }

        btnramour.setOnClickListener {
            val celsiusStr = etbilcelcius.text.toString()

            if (celsiusStr.isEmpty()) {
                Toast.makeText(this, "Masukkan suhu dalam Celsius", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val celsius = celsiusStr.toDouble()
            val reaumur = celsius * 4.0 / 5.0

            txthasil.text = "Reaumur: %.2f".format(reaumur)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }