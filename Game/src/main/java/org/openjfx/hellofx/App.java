package org.openjfx.hellofx;


import java.io.IOException;
import java.util.ArrayList;import javax.swing.event.EventListenerList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
  
//	ALL GUI VARIABLES
	
	private GridPane gridPane = new GridPane();
	private BorderPane borderPane = new BorderPane();
	private Label title = new Label("Tic Tac Toe Game");
    private Button resetButton = new Button("Restart Game");
    Font font = Font.font("Roboto", FontWeight.BOLD, 30);
    
    
    private ArrayList<Button> btns = new ArrayList<>();
    
//    ALL LOGIC VARIABLES
    boolean gameOver = true;
    int activePlayer  = 0;
    int gameState[] = {3,3,3,3,3,3,3,3,3};
    int winningPosition[][] = {
    		{0,1,2},
    		{3,4,5},
    		{6,7,8},
    		{0,3,6},
    		{1,4,7},
    		{2,5,8},
    		{0,4,6},
    		{2,4,6}
    		
    };
    
    
    
    
      
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
       
    
    	
    	this.createGUI();
        this.handleEvent();
    	
    	Scene sc = new Scene(borderPane,550,650);
    	
    	stage.setScene(sc);
    	
    	stage.show();
    	
    	
    	
    	
    }

 

 
//  THIS FUNCTION IS FOR CREATING GUI
    private void createGUI() {
    	
//    CREATING TITLE
      title.setFont(font);
         
//      CREATING RESTART BUTTON 
      resetButton.setFont(font);
      resetButton.setDisable(true);
      
//    	SETTING TITLE AND RESTART BUTTON TO BORDERPANE
      borderPane.setTop(title);
      borderPane.setBottom(resetButton);
      
//        SETTING BORDERPANE COMPONENT TO CENTER
      BorderPane.setAlignment(resetButton, Pos.CENTER);
      borderPane.setAlignment(title,Pos.CENTER);
      
//      PAADING
      borderPane.setPadding(new Insets(20,20,20,20));
      
      
//      WORKING ON 9 GAME BUTTONS
      
      int lable = 0;
      
      for(int i=0;i<3;i++) {
    	  
    	 for(int j=0;j<3;j++) {
    		 
    		 
    		 Button button = new Button();
    		 button.setId(lable+"");
    		 button.setFont(font);
    		 button.setPrefWidth(140);
    		 button.setPrefHeight(140);
    		 gridPane.add(button, j, i);
    		 gridPane.setAlignment(Pos.CENTER);
    		 btns.add(button);
    		 lable++;
    		 
    		 
    	 }
    	  
    	  
      }
      
      
            borderPane.setCenter(gridPane);
      
    	
    	
		
	}

    
//    METHOD FOR HANDLING EVENTS
    private void handleEvent() {
    	
//    	RESTART BUTTON CLICK
    	resetButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
			
				
			}
		});
    	
    	for(Button bn : btns) {
    		
    		bn.setOnAction(new EventHandler<ActionEvent>() {
    			
    			@Override
    			public void handle(ActionEvent event) {
    				
    				
    				 
    			 	Button currentBtn = (Button)event.getSource();
    			 	
    			 	String id = currentBtn.getId();
    			 	int idI = Integer.parseInt(id);
    			 	
    			 	if(gameOver) {
    			 		
//    			 		GAME OVER PRINT MESSAGES
    			 		
    			 		Alert alert = new Alert(AlertType.ERROR);
    			 		alert.setTitle("Error message");
    			 		alert.setContentText("Game Over !! Try to restart the game");
    			 		alert.show();
    			 		
    			 	}else {
    			 		
//    			 		
    			 		
    			 	}
    			 	
    			}
    		});
    		
    	}
    	
    }



	public static void main(String[] args) {
        launch();
    }

}