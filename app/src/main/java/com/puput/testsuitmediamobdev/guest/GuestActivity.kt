package com.puput.testsuitmediamobdev.guest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.puput.testsuitmediamobdev.adapter.GuestAdapter
import com.puput.testsuitmediamobdev.databinding.ActivityGuestBinding
import com.puput.testsuitmediamobdev.model.GuestModel


class GuestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestBinding
    private lateinit var guestAdapter: GuestAdapter
    private val resultCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvGuest.setHasFixedSize(true)
        showRvGuest()
    }

    private fun showRvGuest() {
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[GuestViewModel::class.java]
        guestAdapter = GuestAdapter()

        viewModel.setDataGuest()
        viewModel.getDataGuest().observe(this) {
            guestAdapter.setGuest(it)
            binding.apply {
                rvGuest.layoutManager = GridLayoutManager(this@GuestActivity, 2)
                rvGuest.adapter = guestAdapter
                guestAdapter.setOnItemClickCallback(object : GuestAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: GuestModel) {

                        val guestBirthDate = data.birthdate
                        val date = guestBirthDate.split("-".toRegex()).toTypedArray()
                        val birthDate = date[2].toInt()

                        if (birthDate % 2 == 0 && birthDate % 3 == 0) {
                            Toast.makeText(this@GuestActivity, "iOS", Toast.LENGTH_LONG).show()
                        } else if (birthDate % 2 == 0) {
                            Toast.makeText(this@GuestActivity, "blackberry", Toast.LENGTH_LONG)
                                .show()
                        } else if (birthDate % 3 == 0) {
                            Toast.makeText(this@GuestActivity, "android", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this@GuestActivity, "feature phone", Toast.LENGTH_LONG)
                                .show()
                        }

                        val resultIntent = Intent()
                        resultIntent.putExtra("GUEST-NAME", data.name)

                        setResult(resultCode, resultIntent)
                        finish()
                    }
                })
            }
        }

    }
}