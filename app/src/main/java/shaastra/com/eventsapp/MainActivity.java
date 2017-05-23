package shaastra.com.eventsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        ArrayList<EventCategory> eventCategories = new ArrayList<EventCategory>();
        initEventCategories(eventCategories);

        //TextView mainTitle = (TextView) findViewById(R.id.mainTitle);
        //mainTitle.setText(loadJSONStringFromAsset("sampleEvents.json"));


        EventCategoryAdapter eventCategoryAdapter = new EventCategoryAdapter(this,eventCategories);
        gridView.setAdapter(eventCategoryAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventCategoryAdapter evCagAd = (EventCategoryAdapter) parent.getAdapter();
                EventCategory evCag = evCagAd.getItem(position);

                Intent i = createEvCagIntent(evCag);

                startActivity(i);

            }
        });

    }

    public Intent createEvCagIntent(EventCategory eventCategory){
        Intent i = new Intent(this,EventCategoryActivity.class);
        i.putExtra("eventCategory", (Serializable) eventCategory);
        return i;
    }

    public void initEventCategories(ArrayList<EventCategory> evCags){
        /*EventCategory evcag1 = new EventCategory("Coding events",null);
        evcags.add(evcag1);
        EventCategory evcag2 = new EventCategory("Business events",null);
        evcags.add(evcag2);
        EventCategory evcag3 = new EventCategory("Quizzing events",null);
        evcags.add(evcag3);
        EventCategory evcag4 = new EventCategory("Robotics events",null);
        evcags.add(evcag4);*/

        String samplesString = loadJSONStringFromAsset("sampleEvents.json");
        try {
            JSONObject sampleFile = new JSONObject(samplesString);
            JSONArray eventCags = sampleFile.getJSONArray("eventCategories");
            for(int i=0;i<eventCags.length();i++){
                JSONObject evCagJSON = eventCags.getJSONObject(i);

                ArrayList<Event> evs = new ArrayList<Event>();
                JSONArray evsJSON = evCagJSON.getJSONArray("events");
                for(int j=0;j<evsJSON.length();j++){
                    JSONObject ev = evsJSON.getJSONObject(j);
                    Event event = new Event(ev);
                    evs.add(event);
                }

                EventCategory evCag = new EventCategory(evCagJSON.getString("eventCategoryName"), evs);
                evCags.add(evCag);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONStringFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = this.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
