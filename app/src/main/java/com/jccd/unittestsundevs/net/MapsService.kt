package com.jccd.unittestsundevs.net

import com.jccd.unittestsundevs.net.response.LocationResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MapsService {

    @GET("geolocation/nearby")
    fun getLocationsNearby(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("radius") radius: Double,
        @Query("limit") limit: Int
    ): Observable<LocationResponse>
}