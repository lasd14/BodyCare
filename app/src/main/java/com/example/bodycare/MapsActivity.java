package com.example.bodycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = (float) 16.0;

        //Gimnasio UTP
        LatLng utp = new LatLng(9.0238056, -79.5323694);
        mMap.addMarker(new MarkerOptions().position(utp).title("Gimnasio UTP").snippet("Universidad Tecnológica de Panamá Gimnasio Gratuito").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.gym)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(utp, zoomLevel));

        //PowerClub Bethania
        LatLng powerclub = new LatLng(9.00304, -79.5333753);
        mMap.addMarker(new MarkerOptions().position(powerclub).title("Powerclub Bethania").snippet("Powerclub sucursal de Bethania").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.gym)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(utp, zoomLevel));

        //Planet Fitness Centennial
        LatLng planet = new LatLng(9.0294929, -79.5304225);
        mMap.addMarker(new MarkerOptions().position(planet).title("Planet Fitness").snippet("Planet Fitness sucursal de Centennial").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.gym)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(utp, zoomLevel));

        //Krav Maga - Condado del Rey
        LatLng krav = new LatLng(9.029180, -79.525035);
        mMap.addMarker(new MarkerOptions().position(krav).title("Krav Maga").snippet("Gimnasio y escuela Krav Maga").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.gym)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(utp, zoomLevel));

    }
}