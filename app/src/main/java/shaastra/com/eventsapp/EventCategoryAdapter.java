package shaastra.com.eventsapp;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajat on 21-05-2017.
 */

public class EventCategoryAdapter extends ArrayAdapter<EventCategory> {


    public EventCategoryAdapter(Context context, ArrayList<EventCategory> eventCategories) {
        super(context, 0, eventCategories);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EventCategory eventCategory = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        int layout = 0;
        /*if(match.showDetails){
            layout = R.layout.list_item_match_detailed;
        }else{
            layout = R.layout.list_item_match_simple;
        }*/
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_category_item, parent, false);
        }
        /*
        if(match.showDetails) {

            TextView team1 = (TextView) convertView.findViewById(R.id.team1);
            TextView team2 = (TextView) convertView.findViewById(R.id.team2);
            team1.setText(match.team1 + "\n" + match.team1Score + "\n" + match.team1Overs + "\n" + match.team1Status);
            team2.setText(match.team2 + "\n" + match.team2Score + "\n" + match.team2Overs + "\n" + match.team2Status);
            if(match.team1Status.equals("Won")){
                team1.setBackgroundColor(Color.argb(100,0,255,0));
                team2.setBackgroundColor(Color.argb(100,255,0,0));
            }else if(match.team2Status.equals("Won")){
                team2.setBackgroundColor(Color.argb(100,0,255,0));
                team1.setBackgroundColor(Color.argb(100,255,0,0));
            }else if(match.team1Status.equals("Batting")){
                team1.setBackgroundColor(Color.argb(100,200,200,0));
                team2.setBackgroundColor(Color.argb(100,0,200,200));
            }else{
                team2.setBackgroundColor(Color.argb(100,200,200,0));
                team1.setBackgroundColor(Color.argb(100,0,200,200));
            }
        }else{
            TextView text = (TextView) convertView.findViewById(R.id.text);
            text.setGravity(Gravity.CENTER_HORIZONTAL);
            text.setText(match.team1+" vs "+match.team2);
        }*/
        TextView text = (TextView) convertView.findViewById(R.id.itemText);
        text.setText(eventCategory.name);
        return convertView;
    }
}


