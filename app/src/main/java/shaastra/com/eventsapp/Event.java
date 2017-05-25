package shaastra.com.eventsapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Rajat on 22-05-2017.
 */

public class Event implements Serializable{

    // Storing almost everything simply as a String for simplicity

    String eventName, desc, coordName, coordNumber, time;
    String loc;
    double lat, lng;
    int prizeMoney;

    public Event(JSONObject obj) {
        try {
            eventName = obj.getString("eventName");
            desc = obj.getString("description");
            coordName = obj.getString("coordName");
            coordNumber = obj.getString("coordNumber");
            time = obj.getString("time");
            loc = obj.getString("location");
            prizeMoney = obj.getInt("prizeMoney");
            lat = obj.getDouble("lat");
            lng = obj.getDouble("lng");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return eventName;
    }
}
