package project3;

import java.lang.String;
import java.lang.Integer;
import java.lang.Double;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import project3.Weather;
import project3.Event;
import project3.SoccerGame;

public class SoccerGamePane extends GridPane {
         
    private final TextField tfName        = new TextField();
    private final TextField tfPlace       = new TextField();
    private final TextField tfDate        = new TextField();
    private final TextField tfTime        = new TextField();
    private final TextField tfAudience    = new TextField();
    private final TextField tfLeague      = new TextField();
    private final TextField tfTeam1       = new TextField();
    private final TextField tfScore1      = new TextField();
    private final TextField tfTeam2       = new TextField();
    private final TextField tfScore2      = new TextField();
    private final TextField tfTemperature = new TextField();
    private final TextField tfWindSpeed   = new TextField();
    private final TextField tfHumidity    = new TextField();
    private final TextField tfCost         = new TextField();
    private final TextField tfRevenue      = new TextField();
    private final TextField tfProfit       = new TextField();
    
    private final RadioButton rbSunnyYes = new RadioButton("Yes");
    private final RadioButton rbSunnyNo  = new RadioButton("No" );
    private final HBox        hBoxSunny  = new HBox(10, this.rbSunnyYes, this.rbSunnyNo);
    private final ToggleGroup sunnyGroup = new ToggleGroup();
     
    private final Label       lblWeekEnd   = new Label      ("Weekend:");
    private final RadioButton rbWeekEndYes = new RadioButton("Yes");
    private final RadioButton rbWeekEndNo  = new RadioButton("No" );
    private final HBox        hBoxWeekEnd  = new HBox(10, this.rbWeekEndYes, this.rbWeekEndNo);
    
    private final Label       lblGoodWeather   = new Label      ("Good Weather:");
    private final RadioButton rbGoodWeatherYes = new RadioButton("Yes"          );
    private final RadioButton rbGoodWeatherNo  = new RadioButton("No"           );
    private final HBox        hBoxGoodWeather  = new HBox(10, this.rbGoodWeatherYes, this.rbGoodWeatherNo);
                
    protected SoccerGamePane() {
        
        this.tfName       .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfPlace      .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfDate       .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTime       .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfAudience   .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTeam1      .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTeam2      .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfScore1     .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfScore2     .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfLeague     .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfTemperature.setAlignment(Pos.BOTTOM_RIGHT);
        this.tfWindSpeed  .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfHumidity   .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfCost       .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfRevenue    .setAlignment(Pos.BOTTOM_RIGHT);
        this.tfProfit     .setAlignment(Pos.BOTTOM_RIGHT);

        
        this.rbSunnyYes.setToggleGroup(this.sunnyGroup);
        this.rbSunnyNo .setToggleGroup(this.sunnyGroup);
        
        Button btSubmit = new Button("Submit");
        Button btClear  = new Button("Clear" );
        
        btSubmit.setOnAction (e -> this.submit());
        btClear .setOnAction (e -> this.clear ());
        
        GridPane.setHalignment(btClear , HPos.LEFT);
        GridPane.setHalignment(btSubmit, HPos.LEFT);
        
        super.add(new Label("Name:"             ), 0, 0); super.add(this.tfName     , 1, 0); super.add(new Label("Place:"       ), 2, 0); super.add(this.tfPlace      , 3, 0);
        super.add(new Label("Date (mm/dd/yyyy):"), 0, 1); super.add(this.tfDate     , 1, 1); super.add(new Label("Time (hh:mm):"), 2, 1); super.add(this.tfTime       , 3, 1);
        super.add(new Label("Audience:"         ), 0, 2); super.add(this.tfAudience , 1, 2); super.add(new Label("League:"      ), 2, 2); super.add(this.tfLeague     , 3, 2);
        super.add(new Label("Team 1:"           ), 0, 3); super.add(this.tfTeam1    , 1, 3); super.add(new Label("Score 1:"     ), 2, 3); super.add(this.tfScore1     , 3, 3);
        super.add(new Label("Team 2:"           ), 0, 4); super.add(this.tfTeam2    , 1, 4); super.add(new Label("Score 2:"     ), 2, 4); super.add(this.tfScore2     , 3, 4);
        super.add(new Label("Sunnny:"           ), 0, 5); super.add(this.hBoxSunny  , 1, 5); super.add(new Label("Temperature:" ), 2, 5); super.add(this.tfTemperature, 3, 5);
        super.add(new Label("Wind Speed:"       ), 0, 6); super.add(this.tfWindSpeed, 1, 6); super.add(new Label("Humidity:"    ), 2, 6); super.add(this.tfHumidity   , 3, 6);
        super.add(new Label("Cost:"             ), 0, 7); super.add(this.tfCost,      1, 7); super.add(new Label("Revenue:"     ), 2, 7); super.add(this.tfRevenue    , 3, 7);
                                                                                             super.add(new Label("Profit: "     ), 2, 8); super.add(this.tfProfit     , 3, 8);
        super.add(btClear                        , 0, 9);                                    super.add(btSubmit                  , 2, 9);
        
        super.setHgap(5);
        super.setVgap(5);
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(5, 5, 5, 5));
        
    }  // SoccerGamePane()        

    public void submit() {
    
        String name   = this.tfName  .getText().trim();
        String place  = this.tfPlace .getText().trim();
        String league = this.tfLeague.getText().trim();

        String[] teams  = {this.tfTeam1.getText().trim(), this.tfTeam2.getText().trim()};
        int   [] scores = {Integer.parseInt(this.tfScore1.getText().trim()), Integer.parseInt(this.tfScore2.getText().trim())};

        int audience = Integer.parseInt(this.tfAudience.getText().trim());
        
        int cost = Integer.parseInt(this.tfCost.getText().trim());
        
        int revenue = Integer.parseInt(this.tfRevenue.getText().trim());
        
        int profit =  Integer.parseInt(this.tfProfit.getText().trim());

        Weather weather = new Weather(this.rbSunnyYes.isSelected(), Double.parseDouble(this.tfTemperature.getText().trim()), Double.parseDouble(this.tfWindSpeed.getText().trim()), Double.parseDouble(this.tfHumidity.getText().trim()));

        Date dateTime = new Date();  // initial value
        try {dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.ENGLISH).parse(this.tfDate.getText().trim() + " " + (this.tfTime.getText().trim().isEmpty()? "00:00" : this.tfTime.getText().trim()));} catch (ParseException ex) {}

        Event event = new Event();
        try { event = new SoccerGame(name, place, dateTime, audience, cost, revenue, profit, teams, scores, league, weather);} catch (ParseException ex) {}

        this.rbWeekEndYes.setSelected( event.isWeekEnd());
        this.rbWeekEndNo .setSelected(!event.isWeekEnd());

        this.rbGoodWeatherYes.setSelected( ((SoccerGame)event).isGoodWeather());
        this.rbGoodWeatherNo .setSelected(!((SoccerGame)event).isGoodWeather());

        super.getChildren().remove(this.lblWeekEnd     );
        super.getChildren().remove(this.hBoxWeekEnd    );
        super.getChildren().remove(this.lblGoodWeather );
        super.getChildren().remove(this.hBoxGoodWeather);
        
        super.add(this.lblWeekEnd     , 0, 8);
        super.add(this.hBoxWeekEnd    , 1, 8);
        super.add(this.lblGoodWeather , 2, 8);
        super.add(this.hBoxGoodWeather, 3, 8);

    }  // submit()    

    public void clear() {
    
        this.tfName        .clear();
        this.tfPlace       .clear();
        this.tfDate        .clear();
        this.tfTime        .clear();
        this.tfAudience    .clear();
        this.tfLeague      .clear();
        this.tfTeam1       .clear();
        this.tfScore1      .clear();
        this.tfTeam2       .clear();
        this.tfScore2      .clear();
        this.tfTemperature .clear();
        this.tfWindSpeed   .clear();
        this.tfHumidity    .clear();
        this.tfCost        .clear();
        this.tfRevenue     .clear();
        this.tfProfit      .clear();
    
        this.rbSunnyYes.setSelected(false);
        this.rbSunnyNo .setSelected(false);
        
        super.getChildren().remove(this.lblWeekEnd     );
        super.getChildren().remove(this.hBoxWeekEnd    );
        super.getChildren().remove(this.lblGoodWeather );
        super.getChildren().remove(this.hBoxGoodWeather);

    }  // clear() 
    
}  // class SoccerGamePane