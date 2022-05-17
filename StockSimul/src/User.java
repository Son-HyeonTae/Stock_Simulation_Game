import java.util.Random;

public class User extends HTS {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		// create instance
 		HTS hts = new HTS();
 		int seed = hts.seed;
 		int wallet[] = hts.wallet;
 		
		Stock stock = new Stock();		
		stock.setting();		
		
		//local variables
		int comindex = 1;
		int num1 = 10;
		int num2 = 10;
		
		// first condition
		hts.seedCheck(seed);
		System.out.println("");
		stock.stockCheck();
		System.out.println("");
		hts.walletCheck(wallet);
		
		System.out.println("------------------------");
		System.out.println("");
		
		stock.sc();
		
		// buy testing
		seed = hts.buy(seed, wallet, comindex, stock.stockCall(comindex), num1); 
		hts.seedCheck(seed);
		System.out.println("");
		stock.stockCheck();
		System.out.println("");
		hts.walletCheck(wallet);
		
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