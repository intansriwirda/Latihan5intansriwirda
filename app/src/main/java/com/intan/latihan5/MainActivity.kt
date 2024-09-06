package com.intan.latihan5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnHitungS: Button
    private lateinit var btnbilangan :Button
    private lateinit var btnbelanja:Button
    private lateinit var btnbangunan:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnHitungS = findViewById<Button>(R.id.btnHitungS)
        val btnBelanja = findViewById<Button>(R.id.btnbelanja)
        val btnBangunan = findViewById<Button>(R.id.btnbangunan)
        val btnbilangan = findViewById<Button>(R.id.btnbilangan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnHitungS.setOnClickListener() {
            Toast.makeText(this, "Menghitung Suhu", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MenghitungSuhu::class.java)
            startActivity(intent)
        }
        btnBangunan.setOnClickListener() {
            Toast.makeText(this, "Menghitung Bangun Ruang", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Bangunan::class.java)
            startActivity(intent)
        }
        btnBelanja.setOnClickListener(){
            Toast.makeText(this,"Menghitung Belanja" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Belanja::class.java)
            startActivity(intent)
        }
        btnbilangan.setOnClickListener(){
            Toast.makeText(this,"Menentukan Bilangan Ganjil atau genap" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Bilangan::class.java)
            startActivity(intent)
        }

    }
}