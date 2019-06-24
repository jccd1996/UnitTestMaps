package com.jccd.unittestsundevs.net.entities

import com.google.gson.annotations.SerializedName


data class Origin(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("radius")
    val radius: Double
)