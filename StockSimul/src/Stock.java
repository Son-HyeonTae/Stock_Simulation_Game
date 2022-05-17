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
		value = new int[] {0, 10000, 20000, 30000, 40000, 50000};
	}
	
	// stock change
	void sc() {
		value[1] = 5000;
	}
	
	// value return
	int stockCall(int i) {
		return value[i];
	}
	
	// show stock
	void stockCheck() {
		System.out.println("<<< 종목 현재가 >>>");
		for (int i=1; i<=5; i++) {
			System.out.println(com[i]+"\t: "+value[i]);
		}
	}
}