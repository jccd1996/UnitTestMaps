package com.jccd.unittestsundevs.ui

import android.content.pm.PackageManager
import android.location.Location
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jccd.unittestsundevs.AppCore
import com.jccd.unittestsundevs.MapsActivity
import com.jccd.unittestsundevs.R


class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        fun newInstance() = MapsFragment()
        const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var viewModel: MapsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.maps_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, MapsViewModelFactory(AppCore.injectMapsRepository()))
            .get(MapsViewModel::class.java)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val currentLocation = LatLng(4.4414151, -75.1895572)
        // Add a marker in Sydney and move the camera
        mMap.addMarker(MarkerOptions().position(currentLocation).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,18.0f))

        viewModel.listMarkers.observe(this, Observer {
//            it.forEach {
//                val marker = LatLng(it.lat, it.long)
//                mMap.addMarker(MarkerOptions().position(marker))
//            }
            it?.forEachIndexed { index, marker ->
                val marker = LatLng(marker.lat, marker.long)
                mMap.addMarker(MarkerOptions().position(marker).title(index.toString()))
            }
        })
        viewModel.getLocationsNearby(4.4414151, -75.1895572)
    }

}
