package application;

public class HTS extends StockGame {
	
	// create instance
	StockGame sg = new StockGame();
	int wallet[] = sg.stock;

	Exchange ex = new Exchange();
	String com[] = ex.company;
	
	// local variable
	int seed = 1000000;
	
	// seed money / company list / company index / stock value / buy counter
	int buy(int seed, int[] wallet, int comindex, int value, int num) {
		if (value * num <= 0 || value * num > seed ) {
			return seed;
		}
		wallet[comindex] += num;
		System.out.println("Trade success : " + com[comindex] + ", " + num + "주");
		return seed -= value * num;
	}
	
	int sell(int seed, int[] wallet, int comindex, int value, int num) {
		if (value * num <= 0 || num <= 0 || wallet[comindex] < num) {
			System.out.println("\"Invalid Order\"");
			return seed;
		}
		wallet[comindex] -= num;
		System.out.println("Trade success : " + com[comindex] + ", " + num + "주");
		return seed += value * num;
	}
}