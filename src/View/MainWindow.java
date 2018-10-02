package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import Model.Money;
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
	
	public static void main(String[] args) 
    {
        launch(args);
    }
 
    public void start(Stage primaryStage) 
    {
    	root = new Pane();

        holder = new StackPane();
        canvas = new Canvas(600, 400);
        
        money = new Money();
        rating = new Rating();
        
        moneyLabel = new Label("Money: " + money.money + "$");
        moneyLabel.setLayoutX(500);
        moneyLabel.setLayoutY(370);
        
        ratingLabel = new Label ("Rating: "+ rating.rating +"*");
        ratingLabel.setLayoutX(420);
        ratingLabel.setLayoutY(370);
        
        Rectangle reception = new Rectangle(50,100,Color.SIENNA);
        reception.setX(470);
        reception.setY(200);
        
        Vector rooms = new Vector();
        
        Room room1 = new Room(0,0,true,true);
        rooms.add(room1);
        Room room2 = new Room(100,0,true,true);
        rooms.add(room2);
        Room room3 = new Room(200,0,true,true);
        rooms.add(room3);
        Room room4 = new Room(300,0,false,true);
        rooms.add(room4);
        Room room5 = new Room(400,0,false,true);
        rooms.add(room5);
        Room room6 = new Room(500,0,false,true);
        rooms.add(room6);
        
        Button buyFourthRoomButton = new Button("Buy");
        buyFourthRoomButton.setLayoutX(335);
        buyFourthRoomButton.setLayoutY(50);
        
        Button buyFifthRoomButton = new Button("Buy");
        buyFifthRoomButton.setLayoutX(435);
        buyFifthRoomButton.setLayoutY(50);
        
        Button buySixthRoomButton = new Button("Buy");
        buySixthRoomButton.setLayoutX(535);
        buySixthRoomButton.setLayoutY(50);
        
        Vector<Visitor> visitors = new Vector();
        Visitor visitor = new Visitor();
        Visitor visitor1 = new Visitor();
        visitors.add(visitor1);
        visitors.add(visitor);
        
        visitor.move(rooms, money);
        new Timer().scheduleAtFixedRate(new TimerTask() { 
        	int i = 0;
            public void run() {
            	visitors.get(i).move(rooms, money);
            	i++;
            }
        }, 5000, 1);
        
       
        
        buyFourthRoomButton.setOnAction(e -> {
        	if (money.money >= 150) {
        		room4.isAvailable = true;
        		money.money = money.money - 150;
        		moneyLabel = new Label("Money: " + money.money + "$");
        	}
        	
        	else {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("This rom costs 150$");
        		alert.setHeaderText("You can't buy this room");
        		alert.setContentText("You don't have enough money!");

        		alert.showAndWait();
        	}
        	
        });
        
        holder.getChildren().addAll(canvas);
        root.getChildren().addAll(holder, reception, room1.form, room2.form, room3.form, room4.form, room5.form, room6.form, buyFourthRoomButton, buySixthRoomButton, buyFifthRoomButton, moneyLabel, ratingLabel, visitor.form, visitor1.form);

        holder.setStyle("-fx-background-color: 	#FFF8DC");
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void refresh() {
    }
}
