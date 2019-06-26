package project3;

import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import project3.MusicEvent;
import project3.Weather;
import project3.GoodWeather;

public final class Concert extends MusicEvent implements GoodWeather {
    
    private String  genre;
    private Weather weather;
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    public Concert(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit, String[] performers, String genre, Weather weather) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit, performers);
        this.setGenre  (genre);
	this.setWeather(weather);
        Concert event = this;
        Concert.eventList.add(event);
    }  // Concert()
    
    public void   setGenre(String genre) {this.genre = genre;}
    public String getGenre() {return this.genre;}

    public void    setWeather(Weather weather) {this.weather = weather;}
    public Weather getWeather() {return this.weather;}
    
    public static ArrayList getEventList() {return Concert.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return Concert.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.GoodWeather.isGoodWeather()
    public boolean isGoodWeather() {return this.getWeather().isGoodWeather();    }

    @Override  // project2.MusicEvent.toString()
    public String toString() {return super.toString() + "[genre = " + this.getGenre() + ", " + ((this.isGoodWeather()) ? "Good Weather" : "Bad Weather") + "]";}
    
}  // class Concert