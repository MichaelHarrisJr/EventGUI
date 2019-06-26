package project3;

import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import project3.MusicEvent;

public final class Orchestra extends MusicEvent {
    
    private boolean casualAttire;
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public Orchestra(String name, String place, Date dateTime, int audience, int cost, int revenue,int profit, String[] performers, boolean casualAttire) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit, performers);
        this.setCasualAttire(casualAttire);
        Orchestra event = this;
        Orchestra.eventList.add(event);
    }  // Orchestra()
    
    public void    setCasualAttire(boolean casualAttire) {this.casualAttire = casualAttire;}
    public boolean  isCasualAttire() {return this.casualAttire;}
    
    public static ArrayList getEventList() {return Orchestra.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return Orchestra.getEventList().size();}  // static method, cannot be over-ridden

    
    @Override  // project2.MusicEvent.toString()
    public String toString() {return super.toString() + " [" + ((this.isCasualAttire()) ? "Casual Attire" : "Formal Attire") + "]";}
    
}  // class Orchestra