package shaastra.com.eventsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        ArrayList<EventCategory> eventCategories = new ArrayList<EventCategory>();
        initEventCategories(eventCategories);


        EventCategoryAdapter eventCategoryAdapter = new EventCategoryAdapter(this,eventCategories);
        gridView.setAdapter(eventCategoryAdapter);

    }

    public void initEventCategories(ArrayList<EventCategory> evcags){
        EventCategory evcag1 = new EventCategory("Coding events",null);
        evcags.add(evcag1);
        EventCategory evcag2 = new EventCategory("Business events",null);
        evcags.add(evcag2);
        EventCategory evcag3 = new EventCategory("Quizzing events",null);
        evcags.add(evcag3);
        EventCategory evcag4 = new EventCategory("Robotics events",null);
        evcags.add(evcag4);
    }
}
