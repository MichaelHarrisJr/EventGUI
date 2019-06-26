package project3;

import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import project3.SportEvent;

public final class BasketBallGame extends SportEvent {
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public BasketBallGame(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit, String[] players, int[] scores, String league) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit, players, scores, league);
        BasketBallGame event = this;
        BasketBallGame.eventList.add(event);
    }  // BasketBallGame()
    
    public static ArrayList getEventList() {return BasketBallGame.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return BasketBallGame.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.SportEvent.toString()
    public String toString() {return super.toString();}
    
}  // class BaseketBallGame