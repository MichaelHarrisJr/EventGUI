package project3;

import java.lang.String;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import project3.SoccerGamePane;
import project3.BasketBallGamePane;
import project3.ConcertPane;
import project3.OrchestraPane;
import project3.ArtEventPane;
import project3.StatisticsPane;

public class TestEventGUI extends Application {
    
    @Override  // javafx.application.Application.start()
    public void start(Stage primaryStage) {
    
        String[] titles = {"Soccer Game", "Basketball Game", "Concert", "Orchestra", "Art Event", "Statistics", "Close"};
        
        ListView<String> listView = new ListView<>(FXCollections.observableArrayList(titles));
        listView.setPrefSize(150, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        SoccerGamePane     soccerGamePane     = new SoccerGamePane    ();
        BasketBallGamePane basketBallGamePane = new BasketBallGamePane();
        ConcertPane        concertPane        = new ConcertPane       ();
        OrchestraPane      orchestraPane      = new OrchestraPane     ();
        ArtEventPane       artEventPane       = new ArtEventPane      ();
        StatisticsPane     statisticsPane     = new StatisticsPane    ();
        
        Pane[] displayPanes = {soccerGamePane, basketBallGamePane, concertPane, orchestraPane, artEventPane, statisticsPane};
        
        Pane pane = new Pane();
        pane.getChildren().add(displayPanes[0]);
        pane.setPadding (new Insets(5, 5, 5, 5));
                
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft  (new ScrollPane(listView));   
        borderPane.setCenter(pane);
        
        listView.getSelectionModel().selectedItemProperty().addListener(ov -> {
            
            pane.getChildren().clear();
            
            for (int i: listView.getSelectionModel().getSelectedIndices()) {
                
                if (i == displayPanes.length) primaryStage.close();
                else {
                         if (displayPanes[i] instanceof ArtEventPane      ) artEventPane      .clear();
                    else if (displayPanes[i] instanceof SoccerGamePane    ) soccerGamePane    .clear();
                    else if (displayPanes[i] instanceof BasketBallGamePane) basketBallGamePane.clear();
                    else if (displayPanes[i] instanceof ConcertPane       ) concertPane       .clear();
                    else if (displayPanes[i] instanceof OrchestraPane     ) orchestraPane     .clear();
                                                                            statisticsPane    .clear();
                    
                    pane.getChildren().add(displayPanes[i]);
                    
                }  // if
            
            }  // for
            
        });  // addListener

        Scene scene = new Scene(borderPane, 450, 170);
        primaryStage.setScene(scene);           // place the scene in the stage
        primaryStage.setTitle("TestEventGUI");  // set the stage title
        primaryStage.show();                    // display the stage
    
    }  // start()
  
    public static void main(String[] args) {Application.launch(args);}
    
}  // TestEventGUI