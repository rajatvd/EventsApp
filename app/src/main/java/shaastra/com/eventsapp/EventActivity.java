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
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event = (Event) getIntent().getSerializableExtra("event");

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
                callNumber(event.coordNumber);
            }
        });

        Log.i("EVENTINFO", event.toString());

    }

    public void callNumber(String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+event.coordNumber));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
            Log.i("PERMISSIONCHECK","NO CALLING PERMISSION");
            return;
        }
        startActivity(callIntent);
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    callNumber(event.coordNumber);

                }else {
                    Toast.makeText(this, "No permission to make a call", Toast.LENGTH_SHORT).show();

                }
                return;
            }

        }
    }


}
