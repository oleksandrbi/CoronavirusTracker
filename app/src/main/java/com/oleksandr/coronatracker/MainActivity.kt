package com.oleksandr.coronatracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esri.arcgisruntime.ArcGISRuntimeEnvironment
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.Basemap
import com.esri.arcgisruntime.mapping.view.MapView


class MainActivity : AppCompatActivity() {

    private var mMapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMapView = findViewById(R.id.mapView)
        setupMap()
    }

    private fun setupMap() {
        if (mMapView != null) {
            ArcGISRuntimeEnvironment.setLicense(getResources().getString(R.string.arcgis_license_key));
            val basemapType = Basemap.Type.STREETS_VECTOR
            val latitude = 34.0270
            val longitude = -118.8050
            val levelOfDetail = 13
            val map = ArcGISMap(basemapType, latitude, longitude, levelOfDetail)
            mMapView!!.map = map
        }
    }

    override fun onPause() {
        if (mMapView != null) {
            mMapView!!.pause()
        }
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        if (mMapView != null) {
            mMapView!!.resume()
        }
    }

    override fun onDestroy() {
        if (mMapView != null) {
            mMapView!!.dispose()
        }
        super.onDestroy()
    }
}
