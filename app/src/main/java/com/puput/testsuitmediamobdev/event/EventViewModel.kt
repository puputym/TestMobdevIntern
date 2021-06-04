package com.puput.testsuitmediamobdev.event

import androidx.lifecycle.ViewModel
import com.puput.testsuitmediamobdev.DummyEvent
import com.puput.testsuitmediamobdev.model.EventModel

class EventViewModel : ViewModel() {
    fun getEvent(): List<EventModel> = DummyEvent.generateEventData()
}