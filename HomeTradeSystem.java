package application;

public class HomeTradeSystem extends StockGame {
	
	// create instances
	StockGame stockgame = new StockGame();
	Market exchange = new Market();

	// local variables
	static int newseed;
	int seed = 1000000;
	int wallet[] = stockgame.stock;
	String company[] = exchange.company;
	
	                                                           //quantity
	int buy(int seed, int[] wallet, int companyIndex, int value, int num) {
		if (value * num <= 0 || value * num > seed ) {
			return seed;
		}
		wallet[companyIndex] += num;
		return seed -= value * num;
	}
	
	int sell(int seed, int[] wallet, int companyIndex, int value, int num) {
		if (value * num <= 0 || num <= 0 || wallet[companyIndex] < num) {
			return seed;
		}
		wallet[companyIndex] -= num;
		return seed += value * num;
	}
}
