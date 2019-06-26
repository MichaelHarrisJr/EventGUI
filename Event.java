package project3;

import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import project3.Week;

public class Event implements Week  {
    
    private String name;
    private String place;
    private Date   dateTime;
    private int    audience;
    private int    cost;
    private int    revenue;
    private int    profit;
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
        
    protected Event() {}
    
    protected Event(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit) {
        this.setName(name); this.setPlace(place); this.setDateTime(dateTime); this.setAudience(audience); this.setCost(cost); this.setRevenue(revenue); this.setProfit(profit);
        Event event = this;
        Event.eventList.add(event);
    }  // Event()
    
    public final void setName(String name) {this.name = name;}
    public String     getName() {return this.name;}
    
    public final void setPlace(String place) {this.place = place;}
    public String     getPlace() {return this.place;}
    
    public final void setDateTime (Date dateTime) {this.dateTime = dateTime;}
    public Date       getDateTime() {return this.dateTime;}
    
    public final void setAudience(int audience) {this.audience = audience;}
    public int        getAudience() {return this.audience;}
    
    public final void setCost(int cost){this.cost = cost;}
    public int         getCost() {return this.cost;}
    
    public final void setRevenue(int revenue){this.revenue = revenue;}
    public int         getRevenue() {return this.revenue;}
    
    public final void setProfit(int profit){this.profit = profit;}
    public int         getProfit()  {return this.profit;}
    
    public String getDateTimeString() {return (new SimpleDateFormat("MM/dd/yyyy HH:mm")).format(this.getDateTime());}
 
    public static ArrayList getEventList() {return Event.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return Event.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.Week
    public boolean isWeekEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getDateTime());
        return (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7);
    }  // isWeekEnd()
    
    @Override  // project2.Week
    public boolean isWeekDay() {return !(this.isWeekEnd());}
    
    @Override  // java.lang.Object.toString()
    public String toString() {return "[class = " + this.getClass().getSimpleName() + ", name = " + this.getName() + ", place = " +this.getPlace()  + ", date/time = " + this.getDateTimeString() +  ", " + ((this.isWeekEnd()) ? "Weekend" : "Weekday") + ", audience = " + this.getAudience() + "]";}
    
}  // class Event