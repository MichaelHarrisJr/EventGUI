 package project3;

import java.lang.Integer;
import java.util.Iterator;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import project3.Event;
import project3.SportEvent;
import project3.MusicEvent;
import project3.ArtEvent;
import project3.SoccerGame;
import project3.BasketBallGame;
import project3.Concert;
import project3.Orchestra;

public class StatisticsPane extends BorderPane{
    
    private final TextField tfEvents          = new TextField();
    private final TextField tfSportEvents     = new TextField();
    private final TextField tfMusicEvents     = new TextField();
    private final TextField tfArtEvents       = new TextField();
    private final TextField tfSoccerGames     = new TextField();
    private final TextField tfBasketBallGames = new TextField();
    private final TextField tfConcerts        = new TextField();
    private final TextField tfOrchestras      = new TextField();
    private final TextArea  taDisplayEvents   = new TextArea ();
    private final TextField tfTotalcost       = new TextField();
    private final TextField tfTotalrevenue    = new TextField();
    private final TextField tfTotalprofit     = new TextField();
    
    protected StatisticsPane() {
        
        this.tfEvents         .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfSportEvents    .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfMusicEvents    .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfArtEvents      .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfSoccerGames    .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfBasketBallGames.setAlignment(Pos.BOTTOM_RIGHT);
        this.tfConcerts       .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfOrchestras     .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTotalcost      .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTotalrevenue   .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTotalprofit    .setAlignment(Pos.BOTTOM_RIGHT);
        
        
        this.tfEvents         .setEditable(false);
        this.tfSportEvents    .setEditable(false);
        this.tfMusicEvents    .setEditable(false);
        this.tfArtEvents      .setEditable(false);
        this.tfSoccerGames    .setEditable(false);
        this.tfBasketBallGames.setEditable(false);
        this.tfConcerts       .setEditable(false);
        this.tfOrchestras     .setEditable(false);
        
        this.taDisplayEvents.setPrefColumnCount(40);
        this.taDisplayEvents.setPrefRowCount   (20);
        this.taDisplayEvents.setWrapText     (true);
        this.taDisplayEvents.setEditable    (false);
        
        Button btCount = new Button("Count");
        Button btClear = new Button("Clear");
        
        btCount.setOnAction (e -> this.count());
        btClear.setOnAction (e -> this.clear());
        
        GridPane.setHalignment(btClear, HPos.LEFT);
        GridPane.setHalignment(btCount, HPos.LEFT);
                
        GridPane gridPane = new GridPane();
        
        gridPane.add(new Label("Events:"      ), 0, 0); gridPane.add(this.tfEvents     , 1, 0);
        gridPane.add(new Label("Sport Events:"), 0, 1); gridPane.add(this.tfSportEvents, 1, 1); gridPane.add(new Label("Music Events:"    ), 2, 1); gridPane.add(this.tfMusicEvents    , 3, 1); gridPane.add(new Label("Art Events:"  ), 4, 1); gridPane.add(this.tfArtEvents,   5, 1); 
        gridPane.add(new Label("Soccer Games:"), 0, 2); gridPane.add(this.tfSoccerGames, 1, 2); gridPane.add(new Label("Basketball Games:"), 2, 2); gridPane.add(this.tfBasketBallGames, 3, 2); gridPane.add(new Label("Total profit:"), 4, 2); gridPane.add(this.tfTotalprofit, 5, 2);
        gridPane.add(new Label("Concerts:"    ), 0, 3); gridPane.add(this.tfConcerts   , 1, 3); gridPane.add(new Label("Orchestras:"      ), 2, 3); gridPane.add(this.tfOrchestras     , 3, 3);
        gridPane.add(new Label("Total Cost:"  ), 0, 4); gridPane.add(this.tfTotalcost  , 1, 4); gridPane.add(new Label("Totalrevenue"     ), 2, 4); gridPane.add(this.tfTotalrevenue   , 3, 4);
        gridPane.add(btClear                   , 0, 5);                                         gridPane.add(btCount                       , 2, 5);
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding  (new Insets(5, 5, 5, 5));
        
        ScrollPane scrollPane = new ScrollPane(this.taDisplayEvents);
        scrollPane.setPadding(new Insets(5, 5, 5, 5));
        
        super.setCenter (gridPane  );
        super.setBottom (scrollPane);        
        super.setPadding(new Insets(5, 5, 5, 5));
        
        BorderPane.setAlignment(gridPane,   Pos.CENTER);
        BorderPane.setAlignment(scrollPane, Pos.BOTTOM_CENTER);
        
    }  // StatisticsPane() 

    public void count() {
    
        this.tfEvents         .setText(Integer.toString(Event         .getNumberOfObjects()));
        this.tfSportEvents    .setText(Integer.toString(SportEvent    .getNumberOfObjects()));
        this.tfMusicEvents    .setText(Integer.toString(MusicEvent    .getNumberOfObjects()));
        this.tfArtEvents      .setText(Integer.toString(ArtEvent      .getNumberOfObjects()));
        this.tfSoccerGames    .setText(Integer.toString(SoccerGame    .getNumberOfObjects()));
        this.tfBasketBallGames.setText(Integer.toString(BasketBallGame.getNumberOfObjects()));
        this.tfConcerts       .setText(Integer.toString(Concert       .getNumberOfObjects()));
        this.tfOrchestras     .setText(Integer.toString(Orchestra     .getNumberOfObjects()));
        
        String events = (Event.getEventList().isEmpty()) ? "" : "Events:\n" + Event.getEventList().toString() + "\n\n";
        
        Iterator<Event> eventListIterator = Event.getEventList().iterator();
	Event event;
        int   eventNumber;
        while (eventListIterator.hasNext()) {
            event       = eventListIterator.next();
            eventNumber = Event.getEventList().indexOf(event) + 1;
            events = events + "Event " + String.valueOf(eventNumber) + ": Class: " + event.getClass().getSimpleName() + ",\tEvent Name: " + event.getName() + "\n";
        }  // while
        
        this.taDisplayEvents.setText(events);
        
    }  // count()    

    public void clear() {
     
        this.tfEvents         .clear();
        this.tfSportEvents    .clear();
        this.tfMusicEvents    .clear();
        this.tfArtEvents      .clear();
        this.tfSoccerGames    .clear();
        this.tfBasketBallGames.clear();
        this.tfConcerts       .clear();
        this.tfOrchestras     .clear();
        this.taDisplayEvents  .clear();
    
    }  // clear()    
    
}  // class StatisticsPane