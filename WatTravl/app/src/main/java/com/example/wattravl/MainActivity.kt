package com.example.wattravl

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wattravl.databinding.ActivityMainBinding
import com.example.wattravl.model.DC.ModelDC
import com.example.wattravl.model.MC.Model
import com.google.android.gms.location.*

class MainActivity : AppCompatActivity() {

    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var longitude: Double = 0.0
    private var latitude: Double = 0.0
    private val fastestInterval: Long = 5000 // 5 seconds
    private lateinit var locationRequest: LocationRequest
    private val requestPermissionCode = 999
    private val interval: Long = 10000 // 10 seconds
    private lateinit var binding: ActivityMainBinding
    private lateinit var longitudeText: TextView
    private lateinit var latitudeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is logged in
        //val isLoggedIn = intent.getBooleanExtra("isloggedin", false)
        //if (!isLoggedIn) {
        //    val intent = Intent(this, LoginActivity::class.java)
        //    startActivity(intent)
        //    finish()
        //    return
        //}

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
        if (!isLoggedIn) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Remove this to stop constant login
        /*
        val editor = sharedPref.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()

         */

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        locationRequest = LocationRequest.create()
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            showAlertMessage()
        }

//        longitudeText = findViewById(R.id.longitudeText)
//        latitudeText = findViewById(R.id.latitudeText)

        checkForPermission(this)
//        startLocationUpdates()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add Location Spinner
        val fromLocationSpinner: Spinner = findViewById(R.id.fromLocationSpinner)
        val toLocationSpinner: Spinner = findViewById(R.id.toLocationSpinner)
        val locationItems = resources.getStringArray(R.array.Locations)
        val locationAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, locationItems)
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromLocationSpinner.adapter = locationAdapter
        toLocationSpinner.adapter = locationAdapter

        // Add Room EditText
        val fromRoomEditText: EditText = findViewById(R.id.fromRoomEditText)
        val toRoomEditText: EditText = findViewById(R.id.toRoomEditText)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            // Get the selected items from the spinners
            val selectedFromLocation = fromLocationSpinner.selectedItem.toString()
            val selectedToLocation = toLocationSpinner.selectedItem.toString()
            val selectedFromRoom = fromRoomEditText.text.toString()
            val selectedToRoom = toRoomEditText.text.toString()
            val accessCheck : CheckBox = findViewById(R.id.accessCheck)
            val indoorCheck : CheckBox = findViewById(R.id.indoorCheck)

            val isAccessability = accessCheck.isChecked
            val isIndoors = indoorCheck.isChecked


            // TODO(Add check here to make sure rooms are valid)
            var invalidRoom = ""
            var validRooms = false
            if (selectedFromLocation == "Davis Centre (DC)") {
                validRooms = ModelDC.getInstance().isClassroom(ModelDC.convertCharRooms(selectedFromRoom))
            } else if (selectedFromLocation == "Mathematics and Computer (MC)") {
                validRooms= Model.getInstance().isClassroom(Model.convertCharRooms(selectedFromRoom))
            } else {
                invalidRoom = "building"
            }


            if (validRooms) {
                if (selectedToLocation == "Davis Centre (DC)") {
                    validRooms = ModelDC.getInstance().isClassroom(ModelDC.convertCharRooms(selectedToRoom))
                } else if (selectedToLocation == "Mathematics and Computer (MC)") {
                    validRooms= Model.getInstance().isClassroom(Model.convertCharRooms(selectedToRoom))
                } else {
                    validRooms = false
                    invalidRoom = "building"
                }

                if (!validRooms) {
                    if (invalidRoom == "") {
                        invalidRoom = "room ${selectedToRoom}"
                    }
                }
            } else {
                if (invalidRoom == "") {
                    invalidRoom = "room ${selectedFromRoom}"
                }
            }

            if (!validRooms) {
                Toast.makeText(this, "Invalid $invalidRoom", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Start SecondActivity and pass the selected items
            val intent = Intent(this, MapActivity::class.java).apply {
                putExtra("SELECTED_FROM_LOCATION", selectedFromLocation)
                putExtra("SELECTED_TO_LOCATION", selectedToLocation)
                putExtra("SELECTED_FROM_ROOM", selectedFromRoom)
                putExtra("SELECTED_TO_ROOM", selectedToRoom)
                putExtra("SELECTED_ACCESS", isAccessability)
                putExtra("SELECTED_INDOOR", isIndoors)
            }
            startActivity(intent)
        }


        val googleMapsViewToggle: Button = findViewById(R.id.button_google_maps)
        googleMapsViewToggle.setOnClickListener {
            // Start SecondActivity and pass the selected items
            startActivity(Intent(this, GoogleMapsActivity::class.java))
        }

//        val locationRefreshButton: Button = findViewById(R.id.refreshButton)
//        locationRefreshButton.setOnClickListener {
//            Log.d("MainActivity", "Refreshing location")
//            updateLocation()
//            startLocationUpdates()
//        }
    }

//    private val locationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult) {
//            Log.d("MainActivity", "mLocationCallback: updating location")
//            updateUI(locationResult.lastLocation)
//        }
//    }

//    private fun updateUI(lastLocation: Location?) {
//        latitude = lastLocation?.latitude ?: 0.0
//        longitude = lastLocation?.longitude ?: 0.0
//        Log.d("MainActivity", "updateUI: $latitude, $longitude")
//        longitudeText.text = "Longitude: $longitude"
//        latitudeText.text = "Latitude: $latitude"
//    }

//    private fun startLocationUpdates() {
//        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        locationRequest.interval = interval
//        locationRequest.fastestInterval = fastestInterval
//
//        val builder = LocationSettingsRequest.Builder()
//        builder.addLocationRequest(locationRequest)
//        val locationSettingsRequest = builder.build()
//        val settingsClient = LocationServices.getSettingsClient(this)
//        settingsClient.checkLocationSettings(locationSettingsRequest)
//
//        if (ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED) {
//            return
//        }
//        fusedLocationClient!!.requestLocationUpdates(
//            locationRequest,
//            locationCallback,
//            null)
//    }

//    private fun updateLocation() {
//        Log.d("MainActivity", "updateLocation: called")
//        checkForPermission(this)
//        fusedLocationClient?.lastLocation?.addOnSuccessListener { updateUI(it) }
//    }

    private fun checkForPermission(context: Context) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED) {
            return
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                requestPermissionCode)
            return
        }
    }

    private fun showAlertMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("The location permission is disabled. Do you want to enable it?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                startActivityForResult(
                    Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    , 10)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
                finish()
            }
        val alert: AlertDialog = builder.create()
        alert.show()
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == requestPermissionCode) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                startLocationUpdates()
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
