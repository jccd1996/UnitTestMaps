package com.jccd.unittestsundevs.net.entities

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("markers")
    val markers: List<Marker>
)