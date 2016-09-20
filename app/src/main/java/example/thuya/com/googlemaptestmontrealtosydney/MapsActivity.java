package example.thuya.com.googlemaptestmontrealtosydney;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button b_toMontreal, b_toSydney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        b_toMontreal = (Button) findViewById(R.id.toMontreal);

        b_toSydney = (Button) findViewById(R.id.toSydney);

        b_toMontreal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng montreal = new LatLng(45.52, -73.56);
                mMap.addMarker(new MarkerOptions().position(montreal).title("Welcome to Montreal"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(montreal));

                CameraUpdate zoom=CameraUpdateFactory.zoomTo(6);
                mMap.animateCamera(zoom);

            }
        });


        b_toSydney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Add a marker in Sydney and move the camera

                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

                CameraUpdate sydneyLocation = CameraUpdateFactory.newLatLngZoom(sydney, 5);
                mMap.animateCamera(sydneyLocation);
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in my home town and move the camera
        LatLng hometown = new LatLng(16.34, 107.5);
        mMap.addMarker(new MarkerOptions().position(hometown).title("Missing you, Hue City"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hometown));

    }
}
