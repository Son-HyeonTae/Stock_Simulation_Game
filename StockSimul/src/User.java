
public class User extends HTS {

	public static void main(String[] args) {
		HTS hts = new HTS();
		int seed = hts.seed;
		int wallet[] = hts.wallet;
		
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
		seed = hts.buy(seed, 10000, 10, wallet, 1); 
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
		seed = hts.sell(seed, 5000, 10, wallet, 1);
		hts.seedcheck(seed);
		hts.walletcheck(wallet);
	}

}