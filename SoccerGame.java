package project3;

import java.lang.String;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import project3.SportEvent;
import project3.Weather;
import project3.GoodWeather;

public final class SoccerGame extends SportEvent implements GoodWeather {
    
    private Weather weather;
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public SoccerGame(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit,String[] teams, int[] scores, String league, Weather weather) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit,teams, scores, league);
        this.setWeather(weather);
        SoccerGame event = this;
        SoccerGame.eventList.add(event);
    }  // SoccerGame()
    
    public void    setWeather(Weather weather) {this.weather = weather;}
    public Weather getWeather() {return this.weather;}
    
    public static ArrayList getEventList() {return SoccerGame.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return SoccerGame.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.GoodWeather.isGoodWeather()
    public boolean isGoodWeather() {return this.getWeather().isGoodWeather();}

    @Override  // project2.SportEvent.toString()
    public String toString() {return super.toString() + " [" +  ((this.isGoodWeather()) ? "Good Weather" : "Bad Weather") + "]";}
    
}  // class SoccerGame