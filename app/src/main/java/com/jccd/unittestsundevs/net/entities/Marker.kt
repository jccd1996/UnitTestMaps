package com.jccd.unittestsundevs.net.entities

import com.google.gson.annotations.SerializedName


data class Marker(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("long")
    val long: Double
)