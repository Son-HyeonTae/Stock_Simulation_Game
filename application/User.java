package application;

import java.util.Scanner;

public class User extends HTS {
	
	public static void main(String[] args) {
		
		// create instance
		StockGame stockgame = new StockGame();
		
 		HTS hts = new HTS();
 		int seed = hts.seed;
 		int wallet[] = hts.wallet;
 		
		Stock stock = new Stock();		
		stock.setting();
		
		Exchange exchange = new Exchange();
		
		Scanner scanner = new Scanner(System.in);

		// game start
		
		
		boolean onLoop = true;
		while (onLoop) {
			stockgame.actionPrint();
			int action = scanner.nextInt();
			System.out.println("");
			
			switch(action) {
			case 1: // check current price
				break;
			case 2: // buy
				exchange.companyPrint();
				int comindex = scanner.nextInt();
				exchange.howMuch();
				int num = scanner.nextInt();
				seed = hts.buy(seed, wallet, comindex, stock.stockCall(comindex), num); 
				break;
			case 3: // sell
				exchange.companyPrint();
				comindex = scanner.nextInt();
				exchange.howMuch();
				num = scanner.nextInt();
				seed = hts.sell(seed, wallet, comindex, stock.stockCall(comindex), num);
				break;
			case 4: // check my seed money
				hts.seedCheck(seed);
				break;
			case 5: // check my stock
				hts.walletCheck(wallet);
				break;
			case 6: // go next step
				stock.sc();
				break;
			default :
				System.out.println("\"Invalid action\"");
			}
		}
	}
}