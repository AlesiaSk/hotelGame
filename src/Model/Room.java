package Model;

import java.util.Vector;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

public class Room {

	public int x;
	public int y;
	public boolean isAvailable;
	public boolean isFree;
	public Rectangle form = new Rectangle(100,100);
	
	public Room (int x, int y, boolean isAvailable, boolean isFree) {
		this.x = x;
		this.y = y;
		this.isAvailable = isAvailable;
		this.isFree = isFree;
		this.form.setStroke(Color.BLACK);
        this.form.setStrokeWidth(2);
        this.form.setX(x);
        this.form.setY(y);
        if(this.isAvailable) {
			if(this.isFree) {
				this.form.setFill(Color.OLIVEDRAB);
			}
			else {
				this.form.setFill(Color.LIGHTCORAL);
			}
		}
		else {
			this.form.setFill(Color.LIGHTSTEELBLUE);
		}
		
	}
	
	public void changeColor(Pane root) {
		if(this.isAvailable) {
			if(this.isFree) {
        		root.getChildren().remove(this.form);
        		root.getChildren().addAll(this.form);
				this.form.setFill(Color.OLIVEDRAB);
			}
			else {
				root.getChildren().remove(this.form);
        		root.getChildren().addAll(this.form);
				this.form.setFill(Color.LIGHTCORAL);
			}
		}
		else {
			root.getChildren().remove(this.form);
    		root.getChildren().addAll(this.form);
			this.form.setFill(Color.LIGHTSTEELBLUE);
		}
	}
	
}
