package shaastra.com.eventsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {


    Event event;

    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1; // A unique id for which
    // permission request was made so that we can identify it in the callback.

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event = (Event) getIntent().getSerializableExtra("event");

        // Setup the values of the UI elements based on the event object which was passed into
        // this activity through the intent extra

        TextView tvName = (TextView) findViewById(R.id.eventName);
        tvName.setText(event.eventName);

        TextView tvDesc = (TextView) findViewById(R.id.eventDescription);
        tvDesc.setText(event.desc);

        TextView tvLoc = (TextView) findViewById(R.id.eventLocation);
        tvLoc.setText("Location\n" + event.loc);

        TextView tvTime = (TextView) findViewById(R.id.eventTime);
        tvTime.setText("Time\n" + event.time);

        TextView tvPrizeMoney = (TextView) findViewById(R.id.eventPrizeMoney);
        tvPrizeMoney.setText("Prize Money: Rs. " + event.prizeMoney);

        TextView tvCoordName = (TextView) findViewById(R.id.eventCoordName);
        tvCoordName.setText(event.coordName);

        TextView tvCoordNumber = (TextView) findViewById(R.id.eventCoordNumber);
        tvCoordNumber.setText(event.coordNumber);

        ImageButton btCallCoord = (ImageButton) findViewById(R.id.eventCallButton);
        btCallCoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call button
                callNumber(event.coordNumber);
            }
        });

        // Button to open the maps activity
        ImageButton btMap = (ImageButton) findViewById(R.id.eventMapsButton);
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps(event.placeId);
            }
        });

        Log.i("EVENTINFO", event.toString());

    }


    // Function to initiate a phone call to a number
    public void callNumber(String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+event.coordNumber));

        // Check if call permissions are not there
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Request the permission if not there
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
            Log.i("PERMISSIONCHECK","NO CALLING PERMISSION");
            return; // Don't attempt to call without permission(the request permission is async), so just return.
        }
        startActivity(callIntent);
    }

    // The request permission callback
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            // Check which permission was requested using the unique id
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted, so call the number.
                    callNumber(event.coordNumber);

                }else {

                    // Permission denied, notify the user that the call can't be made
                    Toast.makeText(this, "No permission to make a call", Toast.LENGTH_SHORT).show();

                }
                return;
            }

        }
    }


    public void openMaps(String placeId){
        Intent i = new Intent(this,EventMapActivity.class);
        startActivity(i);
    }

}
