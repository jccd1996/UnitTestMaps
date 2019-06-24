package com.jccd.unittestsundevs.net.domain

import com.google.gson.annotations.SerializedName

data class LocationData (
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("long")
    val long: Double,
    @SerializedName("radius")
    val radius: Double
)