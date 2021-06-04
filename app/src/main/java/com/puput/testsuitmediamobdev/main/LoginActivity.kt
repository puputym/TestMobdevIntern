package com.puput.testsuitmediamobdev.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.puput.testsuitmediamobdev.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {

            val nama = binding.edtNama.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NAMA", nama)
            startActivity(intent)
        }
    }
}