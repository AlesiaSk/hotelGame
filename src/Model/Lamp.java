package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.layout.Pane;

public class Lamp {

	public Ellipse form = new Ellipse(20,40);
	public boolean isOn;
	
	
	public Lamp() {
		this.isOn = true;
		this.form = new Ellipse();
		this.form.setFill(Color.LEMONCHIFFON);
	}
	
	public void lightfOff(Pane root) {
		root.getChildren().remove(this.form);
		this.isOn = false;
		this.form.setFill(Color.STEELBLUE);
		root.getChildren().add(this.form);
	}
	
	public void lightOn(Pane root) {
		root.getChildren().remove(this.form);
		this.isOn = true;
		this.form.setFill(Color.LEMONCHIFFON);
		root.getChildren().add(this.form);
	}
}
