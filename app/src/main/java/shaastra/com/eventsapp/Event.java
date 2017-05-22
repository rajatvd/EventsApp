package shaastra.com.eventsapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rajat on 22-05-2017.
 */

public class Event {

    String eventName, desc, coordName, coordNumber, time;
    String loc;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return eventName;
    }
}
