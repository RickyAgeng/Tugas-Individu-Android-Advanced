package com.example.e_library

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelamatDatangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selamat_datang)

        val btnMemulai = findViewById<Button>(R.id.btn_memulai)

        btnMemulai.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // atau menggunakan efek transisi
            // startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}