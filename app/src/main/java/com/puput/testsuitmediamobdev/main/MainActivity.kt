package com.puput.testsuitmediamobdev.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.puput.testsuitmediamobdev.R
import com.puput.testsuitmediamobdev.databinding.ActivityMainBinding
import com.puput.testsuitmediamobdev.event.EventActivity
import com.puput.testsuitmediamobdev.guest.GuestActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val eventCode = 1
    private val guestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEvent.setOnClickListener(this)
        binding.btnGuest.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null) {
            val nama = extras.getString("NAMA")
            binding.userName.text = nama
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_event -> {
                val intent = Intent(this@MainActivity, EventActivity::class.java)
                startActivityForResult(intent, eventCode);
            }
            R.id.btn_guest -> {
                val intent = Intent(this@MainActivity, GuestActivity::class.java)
                startActivityForResult(intent, guestCode)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == eventCode) {
            if (data != null) {
                val eventName = data.getStringExtra("EVENT-NAME")
                binding.btnEvent.text = eventName
            }
        } else if (requestCode == guestCode) {
            if (data != null) {
                val guestName = data.getStringExtra("GUEST-NAME")
                binding.btnGuest.text = guestName
            }
        }
    }
}