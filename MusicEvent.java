package project3;

import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import project3.Event;

public class MusicEvent extends Event {

    private String performers[]; 
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    protected MusicEvent(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit, String[] performers) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit);
        this.setPerformers(performers);
        MusicEvent event = this;
        MusicEvent.eventList.add(event);
    }  // MusicEvent()

    public final void setPerformers(String[] performers) {this.performers = performers;}
    public String[]   getPerformers() {return this.performers;}

    public static ArrayList getEventList() {return MusicEvent.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return MusicEvent.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.Event.toString()
    public String toString() {return super.toString() + " [performers = " + Arrays.toString(this.getPerformers()) + "]";}
    
}  // class MusicEvent