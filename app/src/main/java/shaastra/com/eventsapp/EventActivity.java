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

        TextView eventNameTV = (TextView) findViewById(R.id.eventName);
        eventNameTV.setText(event.eventName);

        Log.i("EVENTINFO", event.toString());

    }
}
