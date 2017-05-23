package shaastra.com.eventsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class EventActivity extends AppCompatActivity {


    Event event;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event = (Event) getIntent().getSerializableExtra("event");

        Log.i("EVENTINFO", event.toString());

    }
}
