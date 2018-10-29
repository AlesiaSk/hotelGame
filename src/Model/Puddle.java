package Model;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.layout.Pane;

public class Puddle {

	public Ellipse form = new Ellipse(20,40);
	public boolean isAppear;
	
	public Puddle() {
		this.isAppear = false;
		this.form = new Ellipse();
		this.form.setFill(Color.SKYBLUE);
        this.form.setCenterX(200);
        this.form.setCenterY(200);
        this.form.setRadiusX(30);
        this.form.setRadiusY(20);
        
	}
	
	public void clear() {
		
		this.isAppear = false;
		this.form.setFill(Color.TRANSPARENT);
	}
	
	public void appear() {
		this.isAppear = true;
		this.form.setFill(Color.SKYBLUE);
	}
}
