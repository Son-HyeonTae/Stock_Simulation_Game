
public class User extends HTS {
	
	public static void main(String[] args) {
		
		// create instance
 		HTS hts = new HTS();
		int seed = hts.seed;
		int wallet[] = hts.wallet;
		
		Stock st = new Stock();
		st.setting();		
		
		// first condition
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
		
		// buy testing
		seed = hts.buy(seed, wallet, 1, st.stockCall(1), 10); 
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
		
		//sell testing
		seed = hts.sell(seed, wallet, 1, st.stockCall(1), 6);
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
		
	}
}