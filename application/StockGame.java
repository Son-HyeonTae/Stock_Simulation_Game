package application;

public class StockGame {
	// stock value
	int stock[] = {0, 0, 0, 0, 0, 0};
	
	
	void actionPrint() {
		System.out.println("");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Choose your action");
		System.out.println("1. Check current price");
		System.out.println("2. Buy Stocks");
		System.out.println("3. Sell Stocks");
		System.out.println("4. Check my seed money");
		System.out.println("5. Check Stocks what I have");
		System.out.println("6. I've done (Go to next step)");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("");
		System.out.print("Input Number : ");
	}
}