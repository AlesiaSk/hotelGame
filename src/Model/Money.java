package Model;

public class Money {

	public int money = 100;
	
	public int moneyIncrement(int money, int earnedMoney) {
		money = money + earnedMoney;
		return money;
	}
	
	public int moneyDecrement(int money, int price) {
		money = money - price;
		return money;
	}
}
