
public class HTS extends StockGame {
	
	int seed = 1000000;
	int wallet[] = {0, 0, 0, 0, 0, 0};
	
	void seedcheck(int seed) {
		System.out.println(seed);
	}
	
	void walletcheck(int[] arr) {
		for (int i=1; i<=5; i++) {
			System.out.print("|" + wallet[i] + "|");
		}
		System.out.println("");
	}
	
	// seed money / company list / company index / stock value / buy counter
	int buy(int seed, int[] arr, int comindex, int value, int num) {
		if (value * num <= 0 || value * num > seed ) {
			return -1;
		}
		arr[comindex] += num;
		return seed -= value * num;
	}
	
	int sell(int seed, int[] arr, int comindex, int value, int num) {
		if (value * num <= 0 || num <= 0 || arr[comindex] < num) {
			return -1;
		}
		arr[comindex] -= num;
		return seed += value * num;
	}
}
