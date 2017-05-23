package shaastra.com.eventsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventCategoryActivity extends AppCompatActivity {

    EventCategory eventCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_category);

        TextView title = (TextView) findViewById(R.id.evCagName);
        ListView eventsView = (ListView) findViewById(R.id.evCagList);

        eventCategory = (EventCategory) getIntent().getSerializableExtra("eventCategory");



        ArrayList<Event> eventsList = eventCategory.events;
        String[] eventNames = new String[eventsList.size()];
        for(int i=0;i<eventsList.size();i++){
            eventNames[i] = eventsList.get(i).eventName;
        }

        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventNames);
        eventsView.setAdapter(eventsAdapter);

        title.setText(eventCategory.name);

    }
}
