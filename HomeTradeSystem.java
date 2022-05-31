package application;

public class HomeTradeSystem extends StockGame {
	
	// create instance
	StockGame stockgame = new StockGame();
	int wallet[] = stockgame.stock;

	Market exchange = new Market();
	String company[] = exchange.company;
	
	// local variable
	int seed = 1000000;
	                                                           //quantity
	int buy(int seed, int[] wallet, int companyIndex, int value, int num) {
		if (value * num <= 0 || value * num > seed ) {
			System.out.println("\"Invalid Order\"");
			return seed;
		}
		wallet[companyIndex] += num;
		System.out.println("Trade success : " + company[companyIndex] + ", " + num + "주");
		return seed -= value * num;
	}
	
	int sell(int seed, int[] wallet, int companyIndex, int value, int num) {
		if (value * num <= 0 || num <= 0 || wallet[companyIndex] < num) {
			System.out.println("\"Invalid Order\"");
			return seed;
		}
		wallet[companyIndex] -= num;
		System.out.println("Trade success : " + company[companyIndex] + ", " + num + "주");
		return seed += value * num;
	}
}