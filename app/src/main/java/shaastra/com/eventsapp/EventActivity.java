package shaastra.com.eventsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        tvLoc.setText("Location\n"+event.loc);

        TextView tvTime = (TextView) findViewById(R.id.eventTime);
        tvTime.setText("Time\n"+event.time);

        TextView tvPrizeMoney = (TextView) findViewById(R.id.eventPrizeMoney);
        tvPrizeMoney.setText("Prize Money: Rs. " + event.prizeMoney);

        TextView tvCoordName = (TextView) findViewById(R.id.eventCoordName);
        tvCoordName.setText("Coordinator: "+event.coordName);

        Log.i("EVENTINFO", event.toString());

    }
}
