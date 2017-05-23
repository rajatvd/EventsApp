package shaastra.com.eventsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class EventCategoryActivity extends AppCompatActivity {

    EventCategory eventCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_category);

        TextView title = (TextView) findViewById(R.id.evCagName);
        ListView eventsView = (ListView) findViewById(R.id.evCagList);

        eventCategory = (EventCategory) getIntent().getSerializableExtra("eventCategory");

        title.setText(eventCategory.name);

    }
}
