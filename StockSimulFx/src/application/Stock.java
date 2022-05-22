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
		for (int i = 0; i<value.length; i++) {
			value[i] = (rand.nextInt(10)+5)*10000;
		}
	}

	// create random
	int random(int p) {
		boolean pm = rand.nextBoolean(); //plusMinus
		if (pm == false) {
			return p = ((rand.nextInt((int)(p*0.05)))/100)*(-100);
		}
		else {
			return p = ((rand.nextInt((int)(p*0.05)))/100)*100;
		}
	}
	
	// stock value change
	void stockWave() {
		for (int i=0; i<=value.length; i++) {
			value[i] += random(value[i]);
		}
	}
	
	// return value to
	int stockCall(int i) {
		return value[i];
	}
	
}