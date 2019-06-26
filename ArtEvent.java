package project3;

import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import project3.Event;

public final class ArtEvent extends Event {

    private String type; 
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    protected ArtEvent(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit, String type) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit);
        this.setType(type);
        ArtEvent event = this;
        ArtEvent.eventList.add(event);
    }  // MusicEvent()

    public final void setType(String type) {this.type = type;}
    public String     getType() {return this.type;}

    public static ArrayList getEventList() {return ArtEvent.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return ArtEvent.getEventList().size();}  // static method, cannot be over-ridden
    
    @Override  // project2.Event.toString()
    public String toString() {return super.toString() + " [type = " + this.getType() + "]";}
    
}  // class ArtEvent