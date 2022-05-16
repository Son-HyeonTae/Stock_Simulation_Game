
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
	
	int buy(int seed, int value, int num, int[] arr, int i) {
		if (value * num <= 0 || value * num > seed ) {
			return -1;
		}
		arr[i] += num;
		return seed -= value * num;
	}
	
	int sell(int seed, int value, int num, int[] arr, int i) {
		if (value * num <= 0 || num <= 0 || arr[i] < num) {
			return -1;
		}
		arr[i] -= num;
		return seed += value * num;
	}
}
