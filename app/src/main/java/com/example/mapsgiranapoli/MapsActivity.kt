package com.example.mapsgiranapoli

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    val Napoli_centrale = LatLng(40.845863,14.265194)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        bottom_navigation_view.setOnNavigationItemReselectedListener {item ->
            when (item.itemId)
            {
                R.id.action_preferiti -> Funzione_Prefetiti("Preferiti")
                R.id.action_tutte -> Funzione_Tutte("Tutte")
                R.id.action_mappa -> Funzione_Mappa("Mappa")

            }

        }

    }

    private fun Funzione_Mappa(typePlace: String) {
        mMap.clear()
    }
    private fun Funzione_Prefetiti(typePlace: String) {
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(Napoli_centrale).title("Napoli Centrale"))
    }
    private fun Funzione_Tutte(typePlace: String) {

        mMap.addMarker(MarkerOptions().position(Napoli_centrale).title("Napoli Centrale"))
        val Mergellina = LatLng(40.833316,14.217673)
        mMap.addMarker(MarkerOptions().position(Mergellina).title("Mergellina"))
        val Cavur = LatLng(40.852562,14.259205)
        mMap.addMarker(MarkerOptions().position(Cavur).title("Cavur"))
        val San_Giovanni = LatLng(40.8531998,14.269711)
        mMap.addMarker(MarkerOptions().position(San_Giovanni).title("San Giovanni"))
        val Centro_Direzionale = LatLng(40.850935,14.269333)
        mMap.addMarker(MarkerOptions().position(Centro_Direzionale).title("Centro Direzionale"))
        val Toledo = LatLng(40.843245,14.252895)
        mMap.addMarker(MarkerOptions().position(Toledo).title("Toledo"))


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Napoli_centrale, 12F))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Napoli_centrale, 12F))
    }
}
