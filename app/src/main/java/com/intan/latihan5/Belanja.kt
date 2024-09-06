package com.intan.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Belanja : AppCompatActivity() {
    private lateinit var btnhasil :Button
    private lateinit var txthasil :TextView
    private lateinit var ettotalbelanja :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_belanja)

        btnhasil = findViewById(R.id.btnhasil)
        txthasil =findViewById(R.id.txthasil)
        ettotalbelanja =findViewById(R.id.ettotalbelanja
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnhasil.setOnClickListener {
            val totalBelanja = ettotalbelanja.text.toString().toDoubleOrNull()
            if (totalBelanja != null) {
                var diskon = 0.0 // Initialize discount
                if (totalBelanja < 100000) {
                    diskon = 0.0
                } else if (totalBelanja in 100000.0..500000.0) {
                    diskon = 0.10
                } else if (totalBelanja in 500000.0..1000000.0) {
                    diskon = 0.20
                } else {
                    diskon = 0.30
                }

                val totalDiskon = totalBelanja * diskon
                val totalAkhir = totalBelanja - totalDiskon
                txthasil.text = "Total Belanja: Rp. " + totalBelanja + "\nDiskon: Rp. " + totalDiskon + "\nTotal Setelah Diskon: Rp. " + totalAkhir

            } else {
                txthasil.text = "Input tidak valid!" // Error message for invalid input
            }
        }
    }
}