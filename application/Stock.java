package application;

import java.util.Random;

public class Stock extends Exchange {
	
	// create instance
	StockGame sg = new StockGame();
	int value[] = sg.stock;
	
	Exchange ex = new Exchange();
	String com[] = ex.company;
	
	Random rand = new Random();
	
	// value initialize
	void setting() {
		value = new int[] {0, 10000, 10000, 10000, 10000, 10000};
	}

	// create random
	int random(int p) {
		boolean pm = rand.nextBoolean(); //plusMinus
		if (pm == false) {
			return p = ((rand.nextInt((int)(p*0.3)))/100)*(-100);
		}
		else {
			return p = ((rand.nextInt((int)(p*0.3)))/100)*100;
		}
	}
	
	// stock change
	void sc() {
		for (int i=1; i<=5; i++) {
			value[i] += random(value[i]);
		}
	}
	
	// return value to
	int stockCall(int i) {
		return value[i];
	}
	
}