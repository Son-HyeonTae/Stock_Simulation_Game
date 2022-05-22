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
 		System.out.println("\n1set");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n2set");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n3set");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n4set");
 		stock.stockWave();
 		stock.newsCheck();
 		System.out.println("\n5set");
 		stock.stockWave();
	}
}