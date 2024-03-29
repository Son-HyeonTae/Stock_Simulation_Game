package application;

import java.util.Random;

public class Stock extends Market {
	
	// create instances
	Random random = new Random();
	StockGame stockgame = new StockGame();
	
	// local variables
	int waveCount = 5; // rotate 5 times to wave stock prices
	int badStock, goodStock;
	int value[] = stockgame.stock;
	
	// local methods
	int stockValue(int i) {
		return value[i];
	}

	void setNews() {
		badStock = random.nextInt(value.length);
		goodStock = random.nextInt(value.length);
	}

	// value initialize
	void setting() {
		for (int i = 0; i<value.length; i++) {
			value[i] = (random.nextInt(10)+5)*10000;
		}
		setNews();
	}

	// create random
	int waveRandom(int p) {
		boolean pm = random.nextBoolean(); //plusMinus
		if (pm == false) {
			return p = ((random.nextInt((int)(p*0.05)))/100)*(-100);
		}
		else {
			return p = ((random.nextInt((int)(p*0.05)))/100)*100;
		}
	}
	
	// stock value change
	void stockWave() {
		for (int j=0; j<waveCount; j++) {
			for (int i=0; i<value.length; i++) {
				value[i] += waveRandom(value[i]);
				if (i == badStock) {
					value[i] -= 2000;
				}
				if (i == goodStock) {
					value[i] += 2000;
				}
			}
		valueCheck();
		System.out.println("");
		}
	setNews();
	}
	
	// back-end testing
	void valueCheck() {
		for(int i=0; i<value.length; i++) {
			System.out.print("["+value[i]+"]");
		}
	}
	
	void newsCheck() {
		System.out.println("호재 : " + goodStock);
		System.out.println("악재 : " + badStock);
	}
}
