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
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {


    Event event;


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

        Button btCallCoord = (Button) findViewById(R.id.eventCallButton);
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.i("PERMISSIONCHECK","NO CALLING PERMISSION");
            return;
        }
        startActivity(callIntent);
    }


}
