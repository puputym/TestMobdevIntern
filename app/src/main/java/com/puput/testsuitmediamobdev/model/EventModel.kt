package com.puput.testsuitmediamobdev.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventModel (
    val img : String,
    val name: String,
    val date: String
    ): Parcelable