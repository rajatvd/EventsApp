package shaastra.com.eventsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class EventCategoryActivity extends AppCompatActivity {

    EventCategory eventCategory;

    // Activity to list out the events under a particular event category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_category);

        TextView title = (TextView) findViewById(R.id.evCagName);
        ListView eventsView = (ListView) findViewById(R.id.evCagList);

        // Get the event category object which this activity should display
        eventCategory = (EventCategory) getIntent().getSerializableExtra("eventCategory");


        // We don't plan on adding or changing events WHILE the app is running, so making this
        // array list final isn't a problem
        final ArrayList<Event> eventsList = eventCategory.events;
        String[] eventNames = new String[eventsList.size()];
        for(int i=0;i<eventsList.size();i++){
            eventNames[i] = eventsList.get(i).eventName;
        }

        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventNames);
        eventsView.setAdapter(eventsAdapter);

        eventsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event ev = eventsList.get(position);
                Intent i = createEvIntent(ev);

                // Start a new activity and pass the event object corresponding to what was clicked
                // as an extra in the intent

                startActivity(i);
            }
        });

        title.setText(eventCategory.name);

    }


    public Intent createEvIntent(Event event){
        Intent i = new Intent(this,EventActivity.class);
        i.putExtra("event", (Serializable) event);
        return i;
    }

}
