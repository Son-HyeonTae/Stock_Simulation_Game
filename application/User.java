package application;

public class User extends HTS {
	
	public static void main(String[] args) {
		
		// create instance
		StockGame stockgame = new StockGame();
		HTS hts = new HTS();
		Stock stock = new Stock();
		
		// local variable
 		int seed = hts.seed;
 		int wallet[] = hts.wallet;
 		
 		
 		
 		//-----------------------------------------------------
 		
 		
 		// back-end testing
 		stock.setting();
 		stock.valueCheck();
 		System.out.println("");
 		stock.newsCheck();
 		System.out.println("\n<<<1set>>>");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n<<<2set>>>");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n<<<3set>>>");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n<<<4set>>>");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n<<<5set>>>");
 		stock.stockWave();
	}
}