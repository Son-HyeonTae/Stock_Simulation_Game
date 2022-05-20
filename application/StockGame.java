package application;

import java.util.Scanner;

public class StockGame {
	// stock value
	public int stock[] = {0, 0, 0, 0, 0, 0};
	
	void startGame() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Type your Nickname : ");
		String name = scanner.next();
		
		System.out.println("");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$\t\t\t     $$$");
		System.out.println("$$$  Stock Simulation Game   $$$");
		System.out.println("$$$\t\t\t     $$$");
		System.out.println("$$$  Nickname :\t"+name);
		System.out.println("$$$  Start at : 1,000,000£Ü  $$$");
		System.out.println("$$$\t\t\t     $$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("");
	}
	
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