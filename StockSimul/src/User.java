
public class User extends HTS {
	
	public static void main(String[] args) {
		
		// create instance
 		HTS hts = new HTS();
 		int seed = hts.seed;
 		int wallet[] = hts.wallet;
 		
		Stock stock = new Stock();		
		stock.setting();		
		
		//local variables
		int comindex = 1;
		int num1 = 10;
		int num2 = 6;
		
		// first condition
		hts.seedCheck(seed);
		System.out.println("");
		stock.stockCheck();
		System.out.println("");
		hts.walletCheck(wallet);
		
		System.out.println("------------------------");
		System.out.println("");
		
		// buy testing
		seed = hts.buy(seed, wallet, comindex, stock.stockCall(comindex), num1); 
		hts.seedCheck(seed);
		System.out.println("");
		stock.stockCheck();
		System.out.println("");
		hts.walletCheck(wallet);
		
		stock.sc();
		
		System.out.println("------------------------");
		System.out.println("");
		
		//sell testing
		seed = hts.sell(seed, wallet, comindex, stock.stockCall(comindex), num2);
		hts.seedCheck(seed);
		System.out.println("");
		stock.stockCheck();
		System.out.println("");
		hts.walletCheck(wallet);
	}
}