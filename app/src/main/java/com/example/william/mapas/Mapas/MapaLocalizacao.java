package com.example.william.mapas.Mapas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.william.mapas.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaLocalizacao extends FragmentActivity {

    double lat = 0;
    double longi = 0;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        lat     = GPSBackground.getLatitude();
        longi   = GPSBackground.getLongitude();
        setUpMapIfNeeded();
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }



    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {

        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, longi)).title("XM Sistemas"));

        CameraUpdate location   = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 20);
        CameraUpdate zoom       = CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void streetView(View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraUpdate location   = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 20);
        CameraUpdate zoom       = CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);
    }

}