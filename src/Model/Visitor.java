package Model;

import java.util.Random;
import java.util.Vector;

import View.MainWindow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.paint.Paint;
import javafx.animation.*;
import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.animation.PathTransition;
import javafx.beans.property.StringProperty;

import java.io.Console;
import java.util.Optional;
import javafx.scene.layout.Pane;

public class Visitor {
	
	public Circle form = new Circle();
	
	public Visitor() {
		this.form = new Circle();
		this.form.setFill(randomColor());
        this.form.setStroke(Color.BLACK);
        this.form.setStrokeWidth(1);
        this.form.setRadius(20);
        this.form.relocate(-50, 250);
	}
	public Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
	
	public int numberOfVisitors(int time) {
		Random r = new Random();
		
		if(time < 1) {
			return r.nextInt((3 - 1) + 1) + 1;
		}
		else if (time > 1 && time < 2) {
			return r.nextInt((4 - 2) + 1) + 2;
		}
		else if (time >= 2 && time < 3) {
			return r.nextInt((5 - 3) + 1) + 3;
		}
		else if (time >= 3 && time < 4) {
			return r.nextInt((6 - 4) + 1) + 4;
		}
		else if (time >= 4 && time < 5) {
			return r.nextInt((7 - 5) + 1) + 5;
		}
		return 8;
	}
	
	public void askMessageAppear(Vector<Room> rooms, Money money, Pane root) {
		Circle cir = this.form;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Look at me");
		alert.setHeaderText("I want to live in your hotel!");
		alert.setContentText("Do you have any free room?");
		ButtonType buttonYes = new ButtonType("Yes");
		ButtonType buttonNo = new ButtonType("No");
		MainWindow window = new MainWindow();
		alert.getButtonTypes().setAll(buttonYes, buttonNo);
		Platform.runLater(new Runnable() {
			public void run() {
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == buttonYes){
				
					for(int i = 0; i < rooms.size(); i++) {
					   if (rooms.get(i).isAvailable && rooms.get(i).isFree) {
					         double y = rooms.get(i).form.getLayoutY();
					         TranslateTransition trans = new TranslateTransition();
						     cir.setTranslateX(i*100+85);
						     cir.setTranslateY(y-220);
						     trans.setNode(cir);
						     trans.play(); 
						     rooms.get(i).isFree = false;
						     money.money += 50;
						     waitAndGoHome(rooms.get(i));
						     return;
					   }
					   else if (i == (rooms.size() - 1) && !rooms.get(i).isAvailable){
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Dialog");
							alert.setHeaderText(null);
							alert.setContentText("Sorry! We don't have any free room for you");
	
							alert.showAndWait();

							TranslateTransition trans = new TranslateTransition();
					        trans.setDuration(Duration.seconds(10));
					        trans.setToX(-10);
					        trans.setToY(10);
					        trans.setNode(cir);
					        trans.play();
					        return;
						}
				   }
			} else {
				
				TranslateTransition trans = new TranslateTransition();
		        trans.setDuration(Duration.seconds(10));
		        trans.setToX(-10);
		        trans.setToY(10);
		        trans.setNode(cir);
		        trans.play();
		        return;
			}
			}  
		});
	}
	
	public void move(Vector<Room> rooms, Money money, Pane root) {
		Circle cir = this.form;
		TranslateTransition trans = new TranslateTransition();
	    trans.setDuration(Duration.seconds(5));
	    trans.setToX(490);
	    trans.setToY(10);
	    trans.setNode(cir);
	    trans.play();
	    trans.setOnFinished(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				trans.stop();
				askMessageAppear(rooms, money, root);
			}
		});
		
	}
	
	public void waitAndGoHome(Room room) {
		Circle cir = this.form;
		
	    PauseTransition pause = new PauseTransition(Duration.seconds(15));
	    pause.setOnFinished(e -> {
	    	TranslateTransition trans = new TranslateTransition();
		    cir.setTranslateX(-100);
		    cir.setTranslateY(220);
		    trans.setNode(cir);
		    trans.setDuration(Duration.seconds(3));
		    room.isFree = true;
	        trans.setToX(-10);
	        trans.setToY(10);
	    }
	    
	 );
	    pause.play();
	}
}
