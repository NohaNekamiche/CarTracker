package com.example.cartracker.ui.Trajet

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cartracker.MapsActivity
import com.example.cartracker.R
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.io.IOException
import java.util.*

class TrajetFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
        PlaceSelectionListener {

        private lateinit var trajetViewModel: TrajetViewModel
        private lateinit var mMap: GoogleMap
        private  val  TAG ="info"
        private val AUTOCOMPLETE_REQUEST_CODE = 1
        private lateinit var fusedLocationClient: FusedLocationProviderClient
        private lateinit var lastLocation: Location
        // 1
        private lateinit var locationCallback: LocationCallback
        // 2
        private lateinit var locationRequest: LocationRequest
        private var locationUpdateState = false
        lateinit var placesClient: PlacesClient
        var placeFields= Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG,Place.Field.ADDRESS)
        var mapReady = false
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            trajetViewModel =
                ViewModelProvider(requireActivity()).get(TrajetViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_trajet_page, container, false)
            trajetViewModel.text
                    .observe(viewLifecycleOwner, Observer {
                //val mapFragment =(activity as FragmentActivity).supportFragmentManager


                val mapFragment =childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
                mapFragment.getMapAsync(requireActivity())
              /*  mapFragment.getMapAsync {
                    googleMap ->  mMap = googleMap
                    mapReady=true
                }**/


                fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())


                locationCallback = object : LocationCallback() {
                    override fun onLocationResult(p0: LocationResult) {
                        super.onLocationResult(p0)

                        lastLocation = p0.lastLocation
                        placeMarkerOnMap(LatLng(lastLocation.latitude, lastLocation.longitude))
                    }
                }
            })
            createLocationRequest()
            return root
        }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        private const val REQUEST_CHECK_SETTINGS = 2
        private const val PLACE_PICKER_REQUEST = 3
    }
    override fun onMarkerClick(p0: Marker?)= false
    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(requireActivity(),
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), MapsActivity.LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        mMap.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {

                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)

                placeMarkerOnMap(currentLatLng)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                val dest = LatLng(36.7525, 3.04197)
                //mMap.addPolygon()
                //val polyline1: Polyline =mMap.addPolyline(PolylineOptions()
                //       .clickable(true)
                //     .add(currentLatLng,dest))

                // Position the map's camera near Alice Springs in the center of Australia,
                // and set the zoom factor so most of Australia shows on the screen.

                // Position the map's camera near Alice Springs in the center of Australia,
                // and set the zoom factor so most of Australia shows on the screen.
                // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))

                // Set listeners for click events.

                // Set listeners for click events.
                //mMap.setOnPolylineClickListener(this@MapsActivity)
                //mMap.setOnPolygonClickListener(this)
            }
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (googleMap != null) {
            mMap = googleMap
        }

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(getActivity())

        setUpMap()
    }
    private fun placeMarkerOnMap(location: LatLng) {
        val markerOptions = MarkerOptions().position(location)

        val titleStr = getAddress(location)  // add these two lines
        Log.i("Adr",titleStr)
        markerOptions.title(titleStr)

        mMap.addMarker(markerOptions)
    }
    private fun getAddress(latLng: LatLng): String {
        // 1
        val geocoder = Geocoder(requireActivity())
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            // 2
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            // 3
            if (null != addresses && !addresses.isEmpty()) {
                address = addresses[0]
                for (i in 0 until address.maxAddressLineIndex) {
                    addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
                }
            }
        } catch (e: IOException) {
            Log.e("MapsActivity", e.localizedMessage)
        }

        return addressText
    }
    private fun startLocationUpdates() {
        //1
        if (ActivityCompat.checkSelfPermission(requireActivity(),
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    MapsActivity.LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        //2
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null /* Looper */)
    }

    private fun createLocationRequest() {
        // 1
        locationRequest = LocationRequest()
        // 2
        locationRequest.interval = 10000
        // 3
        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)

        // 4
        val client = LocationServices.getSettingsClient(requireActivity())
        val task = client.checkLocationSettings(builder.build())

        // 5
        task.addOnSuccessListener {
            locationUpdateState = true
            startLocationUpdates()
        }
        task.addOnFailureListener { e ->
            // 6
            if (e is ResolvableApiException) {
                // Location settings are not satisfied, but this can be fixed
                // by showing the user a dialog.
                try {
                    // Show the dialog by calling startResolutionForResult(),
                    // and check the result in onActivityResult().
                    e.startResolutionForResult(requireActivity(),
                            MapsActivity.REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignore the error.
                }
            }
        }
    }

    override fun onPlaceSelected(p0: Place) {
        TODO("Not yet implemented")
    }

    override fun onError(p0: Status) {
        TODO("Not yet implemented")
    }


    // 1
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MapsActivity.REQUEST_CHECK_SETTINGS) {
            if (resultCode == Activity.RESULT_OK) {
                locationUpdateState = true
                startLocationUpdates()
            }
        }
        /*if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                val place = PlacePicker.getPlace(this, data)
                var addressText = place.name.toString()
                addressText += "\n" + place.address.toString()

                placeMarkerOnMap(place.latLng)
            }
        }*/
    }
    // 2
    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    // 3
    public override fun onResume() {
        super.onResume()
        if (!locationUpdateState) {
            startLocationUpdates()
        }
    }

    /* private fun loadPlacePicker() {
         val builder = PlacePicker.IntentBuilder()

         try {
             startActivityForResult(builder.build(this@MapsActivity), PLACE_PICKER_REQUEST)
         } catch (e: GooglePlayServicesRepairableException) {
             e.printStackTrace()
         } catch (e: GooglePlayServicesNotAvailableException) {
             e.printStackTrace()
         }
     }*/

    private fun initPlaces() {
        Places.initialize(
                requireActivity(),
                getString(R.string.api_key)
        )
        placesClient = Places.createClient(requireActivity())

    }
}

private fun GoogleMap.setOnMarkerClickListener(activity: FragmentActivity?) {

}

private fun SupportMapFragment.getMapAsync(activity: FragmentActivity?) {

}

private fun <TResult> Task<TResult>.addOnSuccessListener(trajetFragment: TrajetFragment, activity: Activity) {

}
