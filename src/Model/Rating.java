package Model;

public class Rating {

	public double rating = 3;
	
	public double ratingIncrease(double rating) {
		rating = rating + 0.25;	
		return rating;
	}
	
	public double ratingDecrease(double rating) {
		rating = rating - 0.5;
		return rating;
	}
}
