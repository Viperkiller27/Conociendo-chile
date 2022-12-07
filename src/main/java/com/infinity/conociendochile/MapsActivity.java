package com.infinity.conociendochile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import com.infinity.conociendochile.R;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String mCiudad;
    //private FusedLocationProviderClient fusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mCiudad = getIntent().getStringExtra("ciudad");

        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng ubicacionCiudad = null;
        // Add a marker in Sydney and move the camera
        if (mCiudad.equals("arica")) {
            ubicacionCiudad = new LatLng(-18.4724735, -70.3241673);//arica
        }

        if (mCiudad.equals("iquique")) {

            ubicacionCiudad = new LatLng(-20.2389636, -70.1509841);//iquque
        }

        if (mCiudad.equals("antofagasta")) {
            ubicacionCiudad = new LatLng(-23.6283541, -70.4747691);//antofagasta
        }

        if (mCiudad.equals("copiapo")) {
            ubicacionCiudad = new LatLng(-27.3772624, -70.4747691);//copipo
        }

        if (mCiudad.equals("laserena")) {
            ubicacionCiudad = new LatLng(-29.9059241, -71.2794672);//laserena
        }

        if (mCiudad.equals("coquimbo")) {
            ubicacionCiudad = new LatLng(-29.9705574, -71.33371);//coquimbo
        }

        if (mCiudad.equals("vinadelmar")) {
            ubicacionCiudad = new LatLng(-33.0055093, -71.6002959);//vinadelmar
        }

        if (mCiudad.equals("valparaiso")) {
            ubicacionCiudad = new LatLng(-33.0501956, -71.6460681);//valparaiso
        }

        if (mCiudad.equals("santiago")) {
            ubicacionCiudad = new LatLng(-33.4612101, -70.8425164);//santiago
        }

        /*
        mMap.addMarker(new MarkerOptions()
                .position(ubicacionCiudad)
                .title(mCiudad));

         */

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacionCiudad));
        //fusedLocationClient.getCurrentLocation()
        //fusedLocationClient.getCurrentLocation()
        /*
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
                    System.out.println("GPS");
                    // Logic to handle location object
                }
            }
        });
        */


    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
