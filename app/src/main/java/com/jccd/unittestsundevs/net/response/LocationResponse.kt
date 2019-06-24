package com.jccd.unittestsundevs.net.response

import com.google.gson.annotations.SerializedName
import com.jccd.unittestsundevs.net.entities.Data


data class LocationResponse(

    @SerializedName("data")
    val `data`: Data
)