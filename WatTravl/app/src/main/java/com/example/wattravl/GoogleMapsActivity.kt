package com.example.wattravl

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.gms.common.api.Status
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import com.google.maps.android.PolyUtil
import com.google.maps.model.DirectionsResult
import kotlin.concurrent.thread

class GoogleMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var placesClient: PlacesClient
    private lateinit var searchEditText: EditText

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_googlemaps)

        // Initialize the Places API
        Places.initialize(applicationContext, "AIzaSyCexZN_76I5Pbf6sCj1SKzKxWedxe9spfw")
        placesClient = Places.createClient(this)

        // Set up the search EditText
//        searchEditText = findViewById(R.id.et_search)
        setupPlaceAutocomplete()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Initialize the fused location client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Check for location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        } else {
            // Permission already granted
            getDeviceLocation { }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getDeviceLocation { }
            }
        }
    }

    private fun getDeviceLocation(callback: (LatLng) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request the missing permissions, and then overriding
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        requestSingleLocationUpdate()
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                val origin = LatLng(location.latitude, location.longitude)
                callback(origin)
            } else {
                // In case the location is null, request a single update
                requestSingleLocationUpdate()
            }
        }
    }

    private fun requestSingleLocationUpdate() {
        val locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            numUpdates = 1
            interval = 0
        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                // Remove the location update after getting the current location
                fusedLocationClient.removeLocationUpdates(this)
            }
        }

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
    }

    private fun setupPlaceAutocomplete() {
        val autocompleteFragment = supportFragmentManager
            .findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment

        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                val destination = place.latLng ?: return

                // Fetch the current location and then call fetchRoute
                getDeviceLocation { origin ->
                    mMap.addMarker(MarkerOptions().position(destination).title(place.name)
                    )
                    mMap.addMarker(MarkerOptions().position(origin).title("Current Location"))
                    fetchRoute(origin, destination)
                }
            }

            override fun onError(status: Status) {
                // Handle error
            }
        })
    }

    private fun fetchRoute(origin: LatLng, destination: LatLng) {
        thread {
            try {
                val context = GeoApiContext.Builder()
                    .apiKey("AIzaSyCexZN_76I5Pbf6sCj1SKzKxWedxe9spfw")
                    .build()

                val directionsResult: DirectionsResult = DirectionsApi.newRequest(context)
                    .origin(com.google.maps.model.LatLng(origin.latitude, origin.longitude))
                    .destination(com.google.maps.model.LatLng(destination.latitude, destination.longitude))
                    .await()

                val path = ArrayList<LatLng>()
                for (route in directionsResult.routes) {
                    for (leg in route.legs) {
                        for (step in leg.steps) {
                            path.addAll(PolyUtil.decode(step.polyline.encodedPath))
                        }
                    }
                }

                runOnUiThread {
                    val polylineOptions = PolylineOptions().addAll(path)
                    mMap.addPolyline(polylineOptions)

                    // Adjust the viewport to include the entire route
                    val builder = LatLngBounds.Builder()
                    builder.include(origin)
                    builder.include(destination)
                    for (point in path) {
                        builder.include(point)
                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 100))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
