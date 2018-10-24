package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import Controller.Control;
import Model.*;
import javafx.scene.shape.Shape;
import Model.Rating;
import Model.Room;
import Model.Visitor;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainWindow extends Application {
	 
	public Money money;
	public Rating rating;
	public Label moneyLabel;
	public Label ratingLabel;
	public Pane root;
	public StackPane holder;
	public Canvas canvas;
	public Visitor visitor;
    public Visitor visitor1;
    public Visitor visitor2;
    public Visitor visitor3;
    public Rectangle reception;
    public Room room1;
    public Room room2;
    public Room room3;
    public Room room4;
    public Room room5;
    public Room room6;
    public Button buyFourthRoomButton;
    public Button buyFifthRoomButton;
    public Button buySixthRoomButton;
	
	public static void main(String[] args) 
    {
        launch(args);
    }
 
    public void start(Stage primaryStage) 
    {
    	root = new Pane();
    	Control controller = new Control();
        holder = new StackPane();
        canvas = new Canvas(600, 400);
        
        money = new Money();
        rating = new Rating();
        
        moneyLabel = money.moneyLabel;
        moneyLabel.setLayoutX(500);
        moneyLabel.setLayoutY(370);
        
        ratingLabel = new Label ("Rating: "+ rating.rating +"*");
        ratingLabel.setLayoutX(420);
        ratingLabel.setLayoutY(370);
        
        reception = new Rectangle(50,100,Color.SIENNA);
        reception.setX(470);
        reception.setY(200);
        
        Vector rooms = new Vector();
        
        room1 = new Room(0,0,true,true);
        rooms.add(room1);
        room2 = new Room(100,0,true,true);
        rooms.add(room2);
        room3 = new Room(200,0,true,true);
        rooms.add(room3);
        room4 = new Room(300,0,false,true);
        rooms.add(room4);
        room5 = new Room(400,0,false,true);
        rooms.add(room5);
        room6 = new Room(500,0,false,true);
        rooms.add(room6);
        
        buyFourthRoomButton = new Button("Buy");
        buyFourthRoomButton.setLayoutX(335);
        buyFourthRoomButton.setLayoutY(50);
        
        buyFifthRoomButton = new Button("Buy");
        buyFifthRoomButton.setLayoutX(435);
        buyFifthRoomButton.setLayoutY(50);
        
        buySixthRoomButton = new Button("Buy");
        buySixthRoomButton.setLayoutX(535);
        buySixthRoomButton.setLayoutY(50);
        
        Vector<Visitor> visitors = new Vector();
        visitor = new Visitor();
        visitor1 = new Visitor();
        visitor2 = new Visitor();
        visitor3 = new Visitor();
        visitors.add(visitor);
        visitors.add(visitor1);
        visitors.add(visitor3);
        visitors.add(visitor2);
        
        
        
        new Timer().scheduleAtFixedRate(new TimerTask() { 
        	int i = 0;
            public void run() {
            	if(i < 4) {
            		visitors.get(i).move(rooms, money, root, rating);
            		if(i != rooms.size() - 1) {
            			i++;
            		}
            	}
            		
            }
        }, 1000,7000);
        
       
        
        buyFourthRoomButton.setOnAction(e -> {
        	Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
    		alert.setHeaderText("This room costs 150$");
    		alert.setContentText("Are you sure you want to buy it?");

    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    			if (money.money >= 150) {
            		room4.isAvailable = true;
            		money.money = money.money - 150;
            		moneyLabel = new Label("Money: " + money.money + "$");
            		root.getChildren().remove(buyFourthRoomButton);
            		room4.changeColor(root);
            		controller.updateLabels(root, moneyLabel, ratingLabel);
            	}
    			else {
            		Alert alertRoom = new Alert(AlertType.INFORMATION);
            		alert.setTitle("This rom costs 150$");
            		alert.setHeaderText("You can't buy this room");
            		alert.setContentText("You don't have enough money!");

            		alert.showAndWait();
            	}
    		} else {
    		}
        	
        	
        });
        
        buyFifthRoomButton.setOnAction(e -> {
        	Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
    		alert.setHeaderText("This room costs 300$");
    		alert.setContentText("Are you sure you want to buy it?");

    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    			if (money.money >= 300) {
            		room5.isAvailable = true;
            		money.money = money.money - 300;
            		moneyLabel = new Label("Money: " + money.money + "$");
            		root.getChildren().remove(buyFifthRoomButton);
            		room5.changeColor(root);
            		controller.updateLabels(root, moneyLabel, ratingLabel);
            	}
    			else {
            		Alert alertRoom = new Alert(AlertType.INFORMATION);
            		alert.setTitle("This rom costs 300$");
            		alert.setHeaderText("You can't buy this room");
            		alert.setContentText("You don't have enough money!");

            		alert.showAndWait();
            	}
    		} else {
    		}
        	
        	
        });
        
        buySixthRoomButton.setOnAction(e -> {
        	Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
    		alert.setHeaderText("This room costs 600$");
    		alert.setContentText("Are you sure you want to buy it?");
    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    			if (money.money >= 600) {
            		room6.isAvailable = true;
            		money.money = money.money - 600;
            		moneyLabel = new Label("Money: " + money.money + "$");
            		root.getChildren().remove(buySixthRoomButton);
            		room6.changeColor(root);
            		controller.updateLabels(root, moneyLabel, ratingLabel);
            	}
    			else {
            		Alert alertRoom = new Alert(AlertType.INFORMATION);
            		alert.setTitle("This rom costs 600$");
            		alert.setHeaderText("You can't buy this room");
            		alert.setContentText("You don't have enough money!");

            		alert.showAndWait();
            	}
    		} else {
    		}
        	
        	
        });
        holder.getChildren().addAll(canvas);
        root.getChildren().addAll(holder, reception, room1.form, room2.form, room3.form, room4.form, room5.form, room6.form, buyFourthRoomButton, buySixthRoomButton, buyFifthRoomButton, moneyLabel, ratingLabel, visitor.form, visitor1.form, visitor2.form, visitor3.form);
        
        holder.setStyle("-fx-background-color: 	#FFF8DC");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    

}
