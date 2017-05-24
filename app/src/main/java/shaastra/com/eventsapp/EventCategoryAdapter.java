package shaastra.com.eventsapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Rajat on 21-05-2017.
 */

public class EventCategoryAdapter extends ArrayAdapter<EventCategory> {

    // Custom adapter so that we can display each event category by an image

    public EventCategoryAdapter(Context context, ArrayList<EventCategory> eventCategories) {
        super(context, 0, eventCategories);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EventCategory eventCategory = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_category_item, parent, false);
        }

        Context activity = convertView.getContext();
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.evCagItemImage);
        itemImage.setImageResource(activity.getResources()
                .getIdentifier(eventCategory.iconName , "drawable", activity.getPackageName()));

        return convertView;
    }
}


