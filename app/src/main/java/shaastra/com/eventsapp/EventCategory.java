package shaastra.com.eventsapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Rajat on 22-05-2017.
 */

public class EventCategory implements Serializable{

    // A category under which multiple events can be there.

    ArrayList<Event> events;
    String name;
    String iconName;

    public EventCategory(String nname, ArrayList<Event> evs, String iconname){
        name = nname;
        events = evs;
        iconName = iconname;
    }

    public String toString(){
        return name;
    }

}
