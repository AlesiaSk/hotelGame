package Controller;

import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import Model.Rating;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Control {
	public boolean isWin(Rating rating) {
		if (rating.rating >= 5) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("You are winner!!!");

			alert.showAndWait();
			Platform.exit();
	        System.exit(0);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLose(Rating rating) {
		if (rating.rating <= 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("You are looser!!!");

			alert.showAndWait();
			Platform.exit();
	        System.exit(0);
			return true;
		}
		else {
			return false;
		}
	}
	
    public void updateLabels(Pane root, Label moneyLabel, Label ratingLabel) {
    	root.getChildren().remove(moneyLabel);
		root.getChildren().addAll(moneyLabel);
		moneyLabel.setLayoutX(500);
        moneyLabel.setLayoutY(370);
		root.getChildren().remove(ratingLabel); 
		root.getChildren().addAll(ratingLabel);
		ratingLabel.setLayoutX(420);
        ratingLabel.setLayoutY(370);
    }
}
