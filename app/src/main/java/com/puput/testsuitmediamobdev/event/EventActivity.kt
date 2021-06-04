package com.puput.testsuitmediamobdev.event

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puput.testsuitmediamobdev.adapter.EventAdapter
import com.puput.testsuitmediamobdev.databinding.ActivityEventBinding
import com.puput.testsuitmediamobdev.model.EventModel


class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding
    private lateinit var eventAdapter: EventAdapter
    private val resultCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRvEvent()
    }

    private fun showRvEvent() {
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[EventViewModel::class.java]
        eventAdapter = EventAdapter()
        eventAdapter.setEvent(viewModel.getEvent())

        binding.rvEvent.apply {
            layoutManager = LinearLayoutManager(this@EventActivity)
            setHasFixedSize(true)
            adapter = eventAdapter

            eventAdapter.setOnItemClickCallback(object : EventAdapter.OnItemClickCallback {
                override fun onItemClicked(data: EventModel) {
                    val resultIntent = Intent()
                    resultIntent.putExtra("EVENT-NAME", data.name)
                    setResult(resultCode, resultIntent)
                    finish()
                }

            })

        }


    }
}