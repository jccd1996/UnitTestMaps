package com.jccd.unittestsundevs.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jccd.unittestsundevs.net.domain.LocationData
import com.jccd.unittestsundevs.net.entities.Marker
import com.jccd.unittestsundevs.net.repository.MapsRepository

class MapsViewModel(private val repository: MapsRepository) : ViewModel() {

    val listMarkers = MutableLiveData<List<Marker>>()

    fun getLocationsNearby(lat: Double, long: Double){
        val locationData = LocationData(lat,long,100.0)
        repository.getLocation(locationData){
            listMarkers.value = it
        }
    }
}
