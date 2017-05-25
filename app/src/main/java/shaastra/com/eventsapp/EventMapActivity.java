package shaastra.com.eventsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Event event;
    final static float INITIAL_ZOOM = 17.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        event = (Event) getIntent().getSerializableExtra("event");

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

        // Add a marker on the location of the event which was passed as an extra in the intent
        LatLng eventLoc = new LatLng(event.lat,event.lng);
        mMap.addMarker(new MarkerOptions().position(eventLoc).title(event.loc));

        // Move the camera and zoom it in
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLoc,INITIAL_ZOOM));
    }
}
