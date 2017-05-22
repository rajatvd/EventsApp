package shaastra.com.eventsapp;

import java.util.ArrayList;

/**
 * Created by Rajat on 22-05-2017.
 */

public class EventCategory {

    ArrayList<Event> events;
    String name;

    public EventCategory(String nname, ArrayList<Event> evs){
        name = nname;
        events = evs;
    }

    public String toString(){
        return name;
    }

}
