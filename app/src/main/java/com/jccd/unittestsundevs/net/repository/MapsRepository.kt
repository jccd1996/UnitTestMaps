package com.jccd.unittestsundevs.net.repository

import android.annotation.SuppressLint

import com.jccd.unittestsundevs.net.ApiMaps
import com.jccd.unittestsundevs.net.domain.LocationData
import com.jccd.unittestsundevs.net.entities.Marker
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MapsRepository(private val api: ApiMaps) {

    @SuppressLint("CheckResult")
    fun getLocation(locationData: LocationData, responseCallBack:(List<Marker>?) -> Unit) {
        val observableMaps =  api.service.getLocationsNearby(
             locationData.lat,
             locationData.long,
             locationData.radius,
             50
        )

        observableMaps.subscribeOn(Schedulers.io()) //new Thread
            .observeOn(AndroidSchedulers.mainThread()) // observeOn en la UI Thread;
            .subscribe(
                { result ->
                    responseCallBack.invoke(result.data.markers)
                },
                {
                    responseCallBack.invoke(null)
                }
            )
    }
}