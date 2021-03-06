package project3;

import java.lang.String;
import java.lang.Math;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import project3.Event;
import project3.Game;

public class SportEvent extends Event implements Game {

    private String[] teams  = new String[2];
    private int[]    scores = new int[2];
    private int      winnerIndex;
    private int      loserIndex;
    private String   league;
   
    
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    
    protected SportEvent() {}
    
    protected SportEvent(String name, String place, Date dateTime, int audience, int cost, int revenue, int profit, String[] teams, int[] scores, String league) throws ParseException {
        super(name, place, dateTime, audience, cost, revenue, profit);
        this.setTeams (teams   );
        this.setScores(scores  );
        this.setLeague(league  );
       
        
        SportEvent event = this;
        SportEvent.eventList.add(event);     
    }  // SportEvent()
    
    public final void setTeams(String[] teams) {this.teams = teams;}
    public String[]   getTeams() {return this.teams;}
    
    public final void setScores(int[] scores) {
        this.scores = scores;
        if      (scores[0] > scores[1]) this.winnerIndex = 0;
        else if (scores[0] < scores[1]) this.winnerIndex = 1;
        else                            this.winnerIndex = (Math.random() < 0.5) ? 0 : 1;
        this.loserIndex = (this.winnerIndex == 1) ? 0 : 1;
    }  // setScores()
    
    
    public int[] getScores() {return this.scores;}

    public int getWinnerIndex() {return this.winnerIndex;}
    public int getLoserIndex () {return this.loserIndex;}
    
    public final void setLeague(String league) {this.league = league;}
    public String     getLeague() {return this.league;}
        
    public static ArrayList getEventList() {return SportEvent.eventList;}              // static method, cannot be over-ridden

    public static int getNumberOfObjects() {return SportEvent.getEventList().size();}  // static method, cannot be over-ridden

    @Override  // project2.Game.getWinner()
    public String getWinner() {return this.getTeams()[this.getWinnerIndex()];}  // getWinner()
    
    @Override  // project2.Game.getLoser()
    public String getLoser()  {return this.getTeams()[this.getLoserIndex ()];}
    
    @Override  // project2.Game.getWinnerScore()
    public int getWinnerScore() {return this.getScores()[this.getWinnerIndex()];}  // getWinner()
    
    @Override  // project2.Game.getLoserScore()
    public int getLoserScore() {return this.getScores()[this.getLoserIndex()];}
 
    @Override  // chapter13.Event.toString()
    public String toString() {return super.toString() + " [teams = " + this.getTeams()[0] + " vs " + this.getTeams()[1] + ", scores = " + this.getScores()[0] + " - " + this.getScores()[1] + ", " + this.getWinner() + " won, league = " + this.getLeague() + "]";}
    
}  // class SportEvent