package application;

public class HTS extends StockGame {
	
	// create instance
	StockGame stockgame = new StockGame();
	int wallet[] = stockgame.stock;

	Exchange exchange = new Exchange();
	String company[] = exchange.company;
	
	// local variable
	int seed = 1000000;
	
	// seed money / company list / company index / stock value / buy counter
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