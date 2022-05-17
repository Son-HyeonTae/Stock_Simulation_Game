
public class Stock extends Exchange {
	
	// create instance
	StockGame sg = new StockGame();
	int stock[] = sg.stock;
	
	void setting() {
		stock = new int[] {0, 10000, 20000, 30000, 40000, 50000};
	}
	
	int stockCall(int i) {
		return stock[i];
	}
}