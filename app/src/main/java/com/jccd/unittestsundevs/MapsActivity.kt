package com.jccd.unittestsundevs

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jccd.unittestsundevs.ui.MapsFragment

class MapsActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        showFragment()

    }
    private fun showFragment() {
        // First get FragmentManager object.
        val fragmentManager = this.supportFragmentManager

        // Begin Fragment transaction.
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.containerFragment, MapsFragment.newInstance())

        // Commit the Fragment replace action.
        fragmentTransaction.commit()
    }
}
