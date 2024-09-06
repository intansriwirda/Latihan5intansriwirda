package com.intan.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bangunan : AppCompatActivity() {
    private lateinit var etpanjang: EditText
    private lateinit var ettinggi: EditText
    private lateinit var etlebar: EditText
    private lateinit var txthasil: TextView
    private lateinit var btnVolum: Button
    private lateinit var btnLuasp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bangunan)

        etpanjang = findViewById(R.id.etpanjang)
        ettinggi = findViewById(R.id.ettinggi)
        etlebar = findViewById(R.id.etlebar)
        txthasil = findViewById(R.id.txthasil)
        btnVolum = findViewById(R.id.btnvolum)
        btnLuasp = findViewById(R.id.btnluasp)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnVolum.setOnClickListener {
            val panjang = etpanjang.text.toString().toDoubleOrNull()
            val tinggi = ettinggi.text.toString().toDoubleOrNull()
            val lebar = etlebar.text.toString().toDoubleOrNull()

            if (panjang != null && tinggi != null && lebar != null) {
                val volume = panjang * tinggi * lebar // Menghitung volume
                txthasil.text = "Volume: $volume"
            } else {
                txthasil.text = "Input tidak valid!"
            }
        }
        btnLuasp.setOnClickListener {
            val panjang = etpanjang.text.toString().toDoubleOrNull()
            val tinggi = ettinggi.text.toString().toDoubleOrNull()
            val lebar = etlebar.text.toString().toDoubleOrNull()

            if (panjang != null && tinggi != null && lebar != null) {
                val luasPermukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi)
                txthasil.text = "Luas Permukaan: $luasPermukaan"
            } else {
                txthasil.text = "Input tidak valid!"
            }

        }
    }
}