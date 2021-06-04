package com.puput.testsuitmediamobdev.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GuestModel(
    val id : String,
    val name: String,
    val birthdate: String
): Parcelable