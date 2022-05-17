
public class HTS extends StockGame {
	
	// create instance
	StockGame sg = new StockGame();
	int wallet[] = sg.stock;

	Exchange ex = new Exchange();
	String com[] = ex.company;
	
	// local variable
	int seed = 1000000;
	
	void seedCheck(int seed) {
		System.out.println("보유현금 : " + seed);
	}
	
	// walletCheck
	void walletCheck(int[] arr) {
		System.out.println("<<< 주식보유현황 >>>");
		for (int i=1; i<=5; i++) {
			System.out.println(com[i]+"\t: "+wallet[i]+" 주");
		}
		System.out.println("");
	}
	
	// seed money / company list / company index / stock value / buy counter
	int buy(int seed, int[] wallet, int comindex, int value, int num) {
		if (value * num <= 0 || value * num > seed ) {
			return -1;
		}
		wallet[comindex] += num;
		return seed -= value * num;
	}
	
	int sell(int seed, int[] wallet, int comindex, int value, int num) {
		if (value * num <= 0 || num <= 0 || wallet[comindex] < num) {
			return -1;
		}
		wallet[comindex] -= num;
		return seed += value * num;
	}
}
